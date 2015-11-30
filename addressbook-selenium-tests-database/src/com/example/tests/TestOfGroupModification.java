package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupModification extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsDB();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getGroupHelper().modifyGroup(indx, group);
			// save new state
			SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsDB();
			// compare states
			assertThat(newList, equalTo(oldList.without(group).withAdded(group))); // This approach doesn't work when group.name == null
			Assert.assertEquals(newList, app.getGroupHelper().getGroupsGUI());
		}
	}
}
