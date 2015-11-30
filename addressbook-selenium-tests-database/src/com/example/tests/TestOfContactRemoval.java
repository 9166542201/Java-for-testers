package com.example.tests;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class TestOfContactRemoval extends TestBase {

	@Test
	public void deleteSomeContact() throws Exception {
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContactsDB();
		int size = oldList.size();
		if (size > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(size);
			ContactData contactDeleted = new ContactData();
			app.getContactHelper().deleteContact(indx, contactDeleted);
			// save new state
			List<ContactData> newList = app.getContactHelper().getContactsGUI();
			// validate that deleted contact dose not present in newList 
			assert !newList.contains(contactDeleted);
		}
	}

}
