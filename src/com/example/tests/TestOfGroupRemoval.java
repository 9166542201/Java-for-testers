package com.example.tests;

import org.testng.annotations.Test;

public class TestOfGroupRemoval extends TestBase{

	@Test
	public void deleteSomeGroup() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().gotoGroupPage();
	app.getGroupHelper().deleteGroup(1);
    app.getNavigationHelper().returnToGroupPage();
	}

}
