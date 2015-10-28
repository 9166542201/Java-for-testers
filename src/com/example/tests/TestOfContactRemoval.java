package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class TestOfContactRemoval extends TestBase {

	//@Test
	public void deleteSomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			app.getContactHelper().initContactEdit(indx);
			app.getContactHelper().submitContactDelete();
			app.getNavigationHelper().gotoHomePage();
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();
			// compare states
			oldList.remove(indx);
			Collections.sort(oldList);
		    Collections.sort(newList);
		    assertEquals(newList, oldList);
		}
	}

	@Test
	public void deleteAllContacts() throws Exception {
		app.getNavigationHelper().openMainPage();
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if (oldList.size() > 0) {
			for (int i = 0; i < oldList.size(); i++) {
				app.getContactHelper().initContactEdit(0);
				app.getContactHelper().submitContactDelete();
				app.getNavigationHelper().gotoHomePage();
			}
		}
	}
}
