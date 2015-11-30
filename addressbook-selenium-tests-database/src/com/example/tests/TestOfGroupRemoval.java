package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class TestOfGroupRemoval extends TestBase {

	@Test
	public void deleteSomeGroup() throws Exception {
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroupsDB();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getGroupHelper().deleteGroup(indx);
			// save new sate
			SortedListOf<GroupData> newList = app.getGroupHelper().getGroupsDB();
//			app.getGroupHelper().cachedGroups = null;
			// compare states
			assertThat(newList, equalTo(oldList.without(indx))); // This approach doesn't work when getting data from database!
			//See my version in Contacts where I am  using delete by Id 
			Assert.assertEquals(newList, app.getGroupHelper().getGroupsGUI());
		}
	}

}
