package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class TestOfGroupRemoval extends TestBase {

	@Test
	public void deleteSomeGroup() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size() - 1);
			// actions
			app.getGroupHelper().initGroupDelete(indx);
			app.getGroupHelper().submitGroupDelete();
			app.getNavigationHelper().returnToGroupPage();
			// save new sate
			List<GroupData> newList = app.getGroupHelper().getGroups();
			// compare states
			oldList.remove(indx);
			Collections.sort(oldList);
		    Collections.sort(newList);
			assertEquals(newList, oldList);
		}
	}

	//@Test
	public void deleteAllGroups() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		if (oldList.size() > 0) {
			for (int i = 0; i < oldList.size(); i++) {
				app.getGroupHelper().initGroupDelete(i);
			}
			app.getGroupHelper().submitGroupDelete();
			app.getNavigationHelper().returnToGroupPage();
		}
	}

}
