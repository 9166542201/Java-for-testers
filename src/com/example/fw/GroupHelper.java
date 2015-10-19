package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.DataOfGroupCreation;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initiateGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupCreationForm(DataOfGroupCreation groupData) {
		type(By.name("group_name"), groupData.group_name);
		type(By.name("group_header"), groupData.group_header);
		type(By.name("group_footer"), groupData.group_footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]']["+index+"]"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
	}

}
