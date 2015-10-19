package com.example.tests;

import org.testng.annotations.Test;

public class TestOfGroupCreation extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initiateGroupCreation();
    DataOfGroupCreation groupData = new DataOfGroupCreation();
    groupData.group_name = "Test_group_name";
    groupData.group_header = "Test_group_header";
    groupData.group_footer = "Test_group_header";
    app.getGroupHelper().fillGroupCreationForm(groupData);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initiateGroupCreation();
    DataOfGroupCreation groupData = new DataOfGroupCreation();
    app.getGroupHelper().fillGroupCreationForm(groupData);
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupPage();
  }
}
