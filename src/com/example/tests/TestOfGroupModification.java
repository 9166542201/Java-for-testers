package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupModification extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getGroupHelper().modifyGroup(indx, group);
			// save new state
			// SortedListOf.add()  has been changed by me!!! 
			SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
			Collections.sort(newList);
			app.getGroupHelper().cachedGroups = null;
			// compare states
			// SortedListOf.without()  has been changed by me!!! 
			assertThat(newList, equalTo(oldList.without(indx).withAdded(group)));
		}
	}
}
