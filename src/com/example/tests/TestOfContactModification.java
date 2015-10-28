package com.example.tests;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TestOfContactModification extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contactData) throws Exception {
		app.getNavigationHelper().openMainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getContactHelper().initContactEdit(indx);
			app.getContactHelper().fillContactCreationForm(contactData);
			app.getContactHelper().submitContactUpdate();
			app.getNavigationHelper().gotoHomePage();
			// save new state
			app.getNavigationHelper().openMainPage();
			List<ContactData> newList = app.getContactHelper().getContacts();
			// compare states
			oldList.remove(indx);
			oldList.add(contactData);
			Collections.sort(oldList);
			 System.out.println("oldList-----------------"+oldList.size()); for (ContactData i : oldList) System.out.println(i); //Output to debug
			Collections.sort(newList);
			 System.out.println("newList-----------------"+newList.size()); for (ContactData i : oldList) System.out.println(i); //Output to debug
			assertEquals(newList, oldList);
		}
	}
}
