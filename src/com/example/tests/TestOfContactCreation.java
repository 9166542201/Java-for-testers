package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfContactCreation extends TestBase {

	@Test(dataProvider = "contactsFromFile")
	public void contactCreationWithValidData(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		// action
		app.getContactHelper().createContact(contact);
		// save new state
		// SortedListOf.add() has been changed by me!!!
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		Collections.sort(newList);
		app.getContactHelper().cachedContacts = null;
		// compare states
		assertThat(newList, equalTo(oldList.withAdded(contact)));
	}

	@Test
	public void deleteAllContacts() throws Exception {
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if (oldList.size() > 0) {
			for (int i = 0; i < oldList.size(); i++) {
				app.getContactHelper().initContactEdit(0);
				app.getContactHelper().submitContactDelete();
				app.driver.findElement(By.linkText("home")).click();
			}
		}
	}
}
