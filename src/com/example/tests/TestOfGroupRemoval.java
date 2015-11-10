package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupRemoval extends TestBase {

	@Test
	public void deleteSomeGroup() throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getGroupHelper().deleteGroup(indx);
			// save new sate
			// SortedListOf.add() has been changed by me!!!
			SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
			Collections.sort(newList);
			app.getGroupHelper().cachedGroups = null;
			// compare states
			// SortedListOf.without() has been changed by me!!!
			assertThat(newList, equalTo(oldList.without(indx)));
		}
	}

}
