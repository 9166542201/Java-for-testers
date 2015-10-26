package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void intiateContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactCreationForm(ContactData contactData) {
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
		selectByText(By.name("new_group"), contactData.new_group);
		type(By.name("byear"), contactData.byear);
		type(By.name("address2"), contactData.address2);
		type(By.name("phone2"), contactData.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactEdit(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	}

	public void submitContactDelete() {
		click(By.xpath("(//input[@name='update'])[2]"));
	}

	public void submitContactUpdate() {
		click(By.xpath("(//input[@name='update'])[1]"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			ContactData contact = new ContactData();
			title = title.substring("Select (".length(), title.lastIndexOf(")"));
			if (title.length() == 0) {
				contact.firstname = "";
				contact.lastname = "";
			} else {
				contact.firstname = title.substring(0, title.indexOf(" "));
				contact.lastname = title.substring(title.indexOf(" ") + 1);
			}
			contacts.add(contact);
		}
		return contacts;
	}

}
