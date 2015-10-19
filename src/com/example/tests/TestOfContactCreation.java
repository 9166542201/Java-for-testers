package com.example.tests;

import org.testng.annotations.Test;

public class TestOfContactCreation extends TestBase {

	@Test
	  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().intiateContactCreation();
	    DataOfContactCreation contactData = new DataOfContactCreation();
	    app.getContactHelper().fillContactCreationForm(contactData);
	    app.getContactHelper().submitContactCreation();
	    app.getNavigationHelper().gotoHomePage();
	  }

	  @Test
	  public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		//creating a group for this test
	    app.getNavigationHelper().gotoGroupPage();
	    app.getGroupHelper().initiateGroupCreation();
	    DataOfGroupCreation groupData = new DataOfGroupCreation();
	    groupData.group_name = "Test_group_name1";
	    groupData.group_header = "Test_group_header1";
	    groupData.group_footer = "Test_group_footer1";
	    app.getGroupHelper().fillGroupCreationForm(groupData);
	    app.getGroupHelper().submitGroupCreation();
		//creating the contact
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().intiateContactCreation();
	    DataOfContactCreation contactData = new DataOfContactCreation();
	    contactData.firstname = "F_name";
	    contactData.lastname = "L_name";
	    contactData.address = "Adress1";
	    contactData.home = "home_phone1";
	    contactData.mobile = "mobile_phone";
	    contactData.work = "work_phone";
	    contactData.email = "email";
	    contactData.email2 = "email2";
	    contactData.bday = "1";
	    contactData.bmonth = "January";
	    contactData.byear = "2000";
	    contactData.address2 = "Adress2";
	    contactData.phone2 = "home_phone2";
	    contactData.new_group = "Test_name1";
	    app.getContactHelper().fillContactCreationForm(contactData);
	    app.getContactHelper().submitContactCreation();
	    app.getNavigationHelper().gotoHomePage();
	  }
}
