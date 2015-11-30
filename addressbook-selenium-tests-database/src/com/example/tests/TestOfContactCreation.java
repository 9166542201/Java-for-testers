package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestOfContactCreation extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator", priority = 2)
	public void contactCreationWithValidData(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContactsDB();
		// action
		app.getContactHelper().createContact(contact);
		// save new state
		List<ContactData> newList = app.getContactHelper().getContactsDB();
		// find the created contact in newList
		ContactData contactCreated = null;
		Boolean flag = true;
		for (ContactData newContact : newList) {
			flag = true;
			for (ContactData oldContact : oldList) {
				if (newContact.getId().equals(oldContact.getId()))
					flag = false;
			}
			if (flag) {
				contactCreated = newContact;
				break;
			}
		}
		assert contactCreated != null;
		//validate the created contact via data base
		assert contactCreated.getFirstname().equals(contact.getFirstname())
				& contactCreated.getLastname().equals(contact.getLastname())
				& contactCreated.getEmail().equals(contact.getEmail());

		// compare the DB and GUI
		List<ContactData> contactsGUI = app.getContactHelper().getContactsGUI();
		int index = contactsGUI.indexOf(contactCreated);
		assert index != -1;
		ContactData contactGUI = contactsGUI.get(index);
		assert contactCreated.getFirstname().equals(contactGUI.getFirstname())
				& contactCreated.getLastname().equals(contactGUI.getLastname())
				& contactCreated.getEmail().equals(contactGUI.getEmail())
				& contactCreated.getId().equals(contactGUI.getId());

	}

	@Test(priority = 1)
	public void deleteAllContacts() throws Exception {
		List<ContactData> oldList = app.getContactHelper().getContactsGUI();
		if (oldList.size() > 0) {
			for (int i = 0; i < oldList.size(); i++) {
				app.getContactHelper().initContactEdit(0);
				app.driver.findElement(By.xpath("(//input[@name='update'])[2]")).click();
				app.driver.findElement(By.linkText("home")).click();
			}
		}
	}
}
