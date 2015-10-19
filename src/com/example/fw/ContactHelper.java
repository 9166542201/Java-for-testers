package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.DataOfContactCreation;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void intiateContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactCreationForm(DataOfContactCreation contactData) {
		type(By.name("firstname"), contactData.firstname);
		type(By.name("lastname"), contactData.lastname);
		type(By.name("address"), contactData.address);
		type(By.name("home"), contactData.home);
		type(By.name("mobile"), contactData.mobile);
		type(By.name("work"), contactData.work);
		type(By.name("email"), contactData.email);
		type(By.name("email2"), contactData.email2);
		selectByText(By.name("bday"), contactData.bday);
		selectByText(By.name("bmonth"), contactData.bmonth);
		//selectByText(By.name("new_group"), contactData.new_group);
		type(By.name("byear"), contactData.byear);
		type(By.name("address2"), contactData.address2);
		type(By.name("phone2"), contactData.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void intiateContactEdit(int index) {
	    click(By.xpath("(//img[@alt='Edit'])["+index+"]"));
	}

	public void submitContactDelete() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}

	public void submitContactUpdate() {
		click(By.xpath("(//input[@name='update'])[1]"));
	}

}
