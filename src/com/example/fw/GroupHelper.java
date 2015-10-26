package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initiateGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupCreationForm(GroupData groupData) {
		type(By.name("group_name"), groupData.group_name);
		type(By.name("group_header"), groupData.group_header);
		type(By.name("group_footer"), groupData.group_footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+(index+1)+"]"));
	}

	public void initGroupDelete(int index) {
		selectGroupByIndex(index);
	}

	public void submitGroupDelete() {
		click(By.name("delete"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.group_name=title.substring("Select (".length(), title.length()- ")".length());
			groups.add(group);
		}
		return groups;
	}

}
