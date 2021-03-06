package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public SortedListOf<GroupData> cachedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cachedGroups == null)
			rebuildCache();
		return cachedGroups;
	}

	public void rebuildCache() {
		cachedGroups = new SortedListOf<>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));
		}
	}

	public GroupHelper createGroup(GroupData groupData) {
		manager.navigateTo().groupsPage();
		initiateGroupCreation();
		fillGroupCreationForm(groupData);
		submitGroupCreation();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		initGroupDelete(index);
		submitGroupDelete();
		return this;
	}

	public GroupHelper modifyGroup(int indx, GroupData groupData) {
		initGroupModification(indx);
		fillGroupCreationForm(groupData);
		submitGroupModification();
		return this;
	}

	// ------------------------------------------------------------------------
	public GroupHelper fillGroupCreationForm(GroupData groupData) {
		type(By.name("group_name"), groupData.getName());
		type(By.name("group_header"), groupData.getHeader());
		type(By.name("group_footer"), groupData.getFooter());
		return this;
	}

	public GroupHelper initiateGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cachedGroups = null;
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cachedGroups = null;
		return this;
	}

	public GroupHelper initGroupDelete(int index) {
		selectGroupByIndex(index);
		return this;
	}

	public GroupHelper submitGroupDelete() {
		click(By.name("delete"));
		cachedGroups = null;
		return this;
	}

}
