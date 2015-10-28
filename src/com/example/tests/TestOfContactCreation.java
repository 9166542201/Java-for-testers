package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOfContactCreation extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contactData) throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// action
		app.getContactHelper().intiateContactCreation();
		app.getContactHelper().fillContactCreationForm(contactData);
		app.getContactHelper().submitContactCreation();
		app.getNavigationHelper().gotoHomePage();
		app.getNavigationHelper().openMainPage();
		oldList.add(contactData);
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		// compare states
		Collections.sort(oldList);
		System.out.println("oldList-----------------"); for (ContactData i : oldList) System.out.println(i); //Output to debug
	    Collections.sort(newList);
		System.out.println("newList-----------------"); for (ContactData i : oldList) System.out.println(i); //Output to debug
		Assert.assertEquals(newList, oldList);
	}
}
