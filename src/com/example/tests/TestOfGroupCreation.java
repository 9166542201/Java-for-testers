package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class TestOfGroupCreation extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    //actions
	    app.getGroupHelper().initiateGroupCreation();
		app.getGroupHelper().fillGroupCreationForm(groupData);
		app.getGroupHelper().submitGroupCreation();
		app.getNavigationHelper().returnToGroupPage();
		//save new 
		List<GroupData> newList = app.getGroupHelper().getGroups();
		//compare states
	    oldList.add(groupData);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    }

}
