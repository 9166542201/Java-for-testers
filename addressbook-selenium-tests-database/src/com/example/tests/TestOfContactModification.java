package com.example.tests;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class TestOfContactModification extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) throws Exception {
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContactsDB();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getContactHelper().modifyContact(indx, contact);
			// save new state
			List<ContactData> newList = app.getContactHelper().getContactsDB();
			// compare the result of modification via database
			int index = newList.indexOf(contact);
			assert index != -1;
			ContactData contactModified = newList.get(index);
			assert contactModified.getFirstname().equals(contact.getFirstname())
					& contactModified.getLastname().equals(contact.getLastname())
					& contactModified.getEmail().equals(contact.getEmail())
					& contactModified.getHome().equals(contact.getHome())
					& contactModified.getAddress().equals(contact.getAddress())
					& contactModified.getId().equals(contact.getId());
			// compare the DB and GUI
			ContactData contactGUI = app.getContactHelper().getContactGUI(contactModified.getId());
			assert contactModified.getFirstname().equals(contactGUI.getFirstname())
					& contactModified.getLastname().equals(contactGUI.getLastname())
					& contactModified.getEmail().equals(contactGUI.getEmail())
					& contactModified.getHome().equals(contactGUI.getHome())
					& contactModified.getAddress().equals(contactGUI.getAddress())
					& contactModified.getId().equals(contactGUI.getId());
		}
	}
}
