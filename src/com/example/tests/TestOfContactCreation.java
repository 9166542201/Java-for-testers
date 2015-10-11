package com.example.tests;

import org.testng.annotations.Test;

public class TestOfContactCreation extends TestBase {

	@Test
	  public void testEmptyContactCreation() throws Exception {
		openMainPage();
	    intiateContactCreation();
	    DataOfContactCreation contactData = new DataOfContactCreation();
	    contactData.firstname = "";
	    contactData.lastname = "";
	    contactData.address = "";
	    contactData.home = "";
	    contactData.mobile = "";
	    contactData.work = "";
	    contactData.email = "";
	    contactData.email2 = "";
	    contactData.bday = "";
	    contactData.bmonth = "";
	    contactData.byear = "";
	    contactData.address2 = "";
	    contactData.phone2 = "";
	    contactData.new_group = "";
	    fillContactCreationForm(contactData);
	    submitContactCreation();
	    gotoHomePage();
	  }

	  @Test
	  public void testNonEmptyContactCreation() throws Exception {
		openMainPage();
		//creating a group for this test
	    gotoGroupPage();
	    initiateGroupCreation();
	    DataOfGroupCreation groupData = new DataOfGroupCreation();
	    groupData.group_name = "Test_name1";
	    groupData.group_header = "Test_header1";
	    groupData.group_footer = "Test_footer1";
		fillGroupCreationForm(groupData);
		submitGroupCreation();
		//creating the contact
	    intiateContactCreation();
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
	    fillContactCreationForm(contactData);
	    submitContactCreation();
	    gotoHomePage();
	  }
}
