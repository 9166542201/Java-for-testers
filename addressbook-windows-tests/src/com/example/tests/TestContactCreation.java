package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.example.fw.ApplicationManager.getManager;
import com.example.fw.Contact;

public class TestContactCreation extends TestBase {
	@Test
	public void createContactWithValidData() throws Exception {
		Contact contact = new Contact().setFirstName("FName").setLastName("LName");
		getManager().getContactHelper().createContact(contact);
		Contact getcontact = getManager().getContactHelper().getFirstContact();
		Assert.assertEquals(getcontact, contact);
	}

}
