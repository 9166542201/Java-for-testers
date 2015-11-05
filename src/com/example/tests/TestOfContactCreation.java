package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfContactCreation extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		// action
		app.getContactHelper().createContact(contact);
		// save new state
		// SortedListOf.add()  has been changed by me!!! 
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		Collections.sort(newList);			
		app.getContactHelper().cachedContacts = null;
		// compare states
		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}
}
