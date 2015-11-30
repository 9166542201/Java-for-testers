package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupCreation extends TestBase {

	@Test(dataProvider = "groupsFromFile", priority = 2)
	public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsDB();
		// actions
		app.getGroupHelper().createGroup(groupData);
		// save new
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsDB();
//		app.getGroupHelper().cachedGroups = null;
		// compare states
		assertThat(newList, equalTo(oldList.withAdded(groupData)));
		Assert.assertEquals(newList, app.getGroupHelper().getGroupsGUI());
	}

	@Test(priority = 1)
	public void deleteAllGroups() throws Exception {
		app.navigateTo().mainPage();
		app.navigateTo().groupsPage();
		List<GroupData> oldList = app.getGroupHelper().getGroupsGUI();
		if (oldList.size() > 0) {
			for (int i = 0; i < oldList.size(); i++) {
				app.getGroupHelper().initGroupDelete(i);
			}
			app.getGroupHelper().submitGroupDelete();
			app.navigateTo().returnToGroupPage();
		}
	}

}
