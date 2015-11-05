package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupCreation extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		// actions
		app.getGroupHelper().createGroup(groupData);
		// save new
		// SortedListOf.add()  has been changed by me!!! 
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		Collections.sort(newList);
		app.getGroupHelper().cachedGroups = null;
		// compare states
		assertThat(newList, equalTo(oldList.withAdded(groupData)));
	}

}
