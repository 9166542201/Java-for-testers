package com.example.tests;

import org.testng.annotations.Test;

public class TestOfGroupModification extends TestBase{

	@Test
	public void modifySomeGroup() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupPage();
	app.getGroupHelper().initGroupModification(1);
    DataOfGroupCreation groupData = new DataOfGroupCreation();
    groupData.group_name = "Test_group_name1";
    app.getGroupHelper().fillGroupCreationForm(groupData);
	app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().returnToGroupPage();
	}

}
