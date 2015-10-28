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
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> firstNames = driver.findElements(By.xpath("//tr[@name='entry']//td[3]"));
		List<WebElement> lastNames = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		List<WebElement> emails = driver.findElements(By.xpath("//tr[@name='entry']//td[4]"));
		List<WebElement> homeTelephones = driver.findElements(By.xpath("//tr[@name='entry']//td[5]"));

		assert firstNames.size() == lastNames.size();
		assert firstNames.size() == emails.size();
		assert firstNames.size() == homeTelephones.size();

		for (int i = 0; i < firstNames.size(); i++) {
			ContactData contact = new ContactData();
			contact.firstname = firstNames.get(i).getText();
			contact.lastname = lastNames.get(i).getText();
			contact.email = emails.get(i).getText();
			contact.home = homeTelephones.get(i).getText();
			contacts.add(contact);
		}

		return contacts;
	}

}
