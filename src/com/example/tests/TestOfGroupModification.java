package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class TestOfGroupModification extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData groupData) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupPage();
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();
		if (oldList.size() > 0) {
			Random rnd = new Random();
			int indx = rnd.nextInt(oldList.size());
			// actions
			app.getGroupHelper().initGroupModification(indx);
			app.getGroupHelper().fillGroupCreationForm(groupData);
			app.getGroupHelper().submitGroupModification();
			app.getNavigationHelper().returnToGroupPage();
			// save new state
			List<GroupData> newList = app.getGroupHelper().getGroups();
			// compare states
			oldList.remove(indx);
			oldList.add(groupData);
			Collections.sort(oldList);
			Collections.sort(newList);// без этого не работает при таком
										// генераторе как здесь, когда возможны
										// стоки, которые оличаются только
										// регистром!
			assertEquals(newList, oldList);
		}
	}
}
