package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfContactRemoval extends TestBase {

	@Test
	public void deleteSomeContact() throws Exception {
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		int size = oldList.size(); 
		if (size > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(size);
			app.getContactHelper().deleteContact(indx);
			// save new state
			// SortedListOf.add()  has been changed by me!!! 
			SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
			Collections.sort(newList);
			app.getContactHelper().cachedContacts = null;
			// compare states
			// SortedListOf.without()  has been changed by me!!! 
		    assertThat(newList, equalTo(oldList.without(indx)));
		}
	}

	// @Test
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
