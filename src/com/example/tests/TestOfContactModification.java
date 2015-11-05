package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfContactModification extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getContactHelper().modifyContact(indx, contact);
			// save new state
			// SortedListOf.add()  has been changed by me!!! 
			SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
			Collections.sort(newList);
			app.getContactHelper().cachedContacts = null;
			// compare states
			// SortedListOf.without()  has been changed by me!!! 
			 assertThat(newList, equalTo(oldList.without(indx).withAdded(contact)));
		}
	}
}
