package com.example.tests;

import org.testng.annotations.Test;

public class TestOfGroupCreation extends TestBase{

	@Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initiateGroupCreation();

    DataOfGroupCreation groupData = new DataOfGroupCreation();
    groupData.group_name = "Test_name";
    groupData.group_header = "Test_header";
    groupData.group_footer = "Test_footer";
	fillGroupCreationForm(groupData);

	submitGroupCreation();
    returnToGroupPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupPage();
    initiateGroupCreation();

    DataOfGroupCreation groupData = new DataOfGroupCreation();
    groupData.group_name = "";
    groupData.group_header = "";
    groupData.group_footer = "";
	fillGroupCreationForm(groupData);

	submitGroupCreation();
    returnToGroupPage();
  }
}
