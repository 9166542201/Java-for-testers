package com.example.tests;

import org.testng.annotations.Test;

public class TestOfContactModification extends TestBase {
	
	@Test
	public void modifySomeContact() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().intiateContactEdit(1);
    DataOfContactCreation contactData = new DataOfContactCreation();
    contactData.home = "home_phone_modify";
    app.getContactHelper().fillContactCreationForm(contactData);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().gotoHomePage();
	}
	
}
