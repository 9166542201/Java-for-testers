package com.example.tests;

import org.testng.annotations.Test;


public class TestOfContactRemoval extends TestBase {
	
	@Test
	public void deleteSomeContact() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().intiateContactEdit(1);
    app.getContactHelper().submitContactDelete();
    app.getNavigationHelper().gotoHomePage();
	}
	
}
