package com.example.fw;

import static com.example.fw.HibernateHelper.getHH;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public List<ContactData> cachedContacts;

	public List<ContactData> getContactsDB() {
		if (cachedContacts == null)
			rebuildCache();
		return cachedContacts;
	}

	public void rebuildCache() {
		cachedContacts = getHH().getContacts();
	}

	public List<ContactData> getContactsGUI() {
		List<ContactData> contacts = new ArrayList<>();
		manager.navigateTo().mainPage();
		List<WebElement> ids = driver.findElements(By.xpath("//input[@name='selected[]']"));
		List<WebElement> firstNames = driver.findElements(By.xpath("//tr[@name='entry']//td[3]"));
		List<WebElement> lastNames = driver.findElements(By.xpath("//tr[@name='entry']//td[2]"));
		List<WebElement> emails = driver.findElements(By.xpath("//tr[@name='entry']//td[4]//a"));

		assert firstNames.size() == ids.size();
		assert firstNames.size() == lastNames.size();
		assert firstNames.size() == emails.size();

		for (int i = 0; i < firstNames.size(); i++) {
			ContactData contact = new ContactData().setId(ids.get(i).getAttribute("value"))
					.setFirstname(firstNames.get(i).getText()).setLastname(lastNames.get(i).getText())
					.setEmail(emails.get(i).getText());
			contacts.add(contact);
		}
		return contacts;
	}

	public ContactData getContactGUI(String id) {
		manager.navigateTo().mainPage();
		driver.findElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
		ContactData contact = new ContactData()
				.setId(driver.findElement(By.xpath("//input[@name='id']")).getAttribute("value"))
				.setFirstname(driver.findElement(By.name("firstname")).getAttribute("value"))
				.setLastname(driver.findElement(By.name("lastname")).getAttribute("value"))
				.setEmail(driver.findElement(By.name("email")).getAttribute("value"))
				.setHome(driver.findElement(By.name("home")).getAttribute("value"))
				.setAddress(driver.findElement(By.name("address")).getAttribute("value"));
		manager.navigateTo().mainPage();
		return contact;
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		intiateContactCreation();
		fillContactCreationForm(contact);
		submitContactCreation();
		return this;
	}

	public ContactHelper deleteContact(int indx, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactEdit(indx);
		submitContactDelete(contact);
		return this;
	}

	public ContactHelper modifyContact(int indx, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactEdit(indx);
		fillContactCreationForm(contact);
		submitContactUpdate(contact);
		return this;
	}

	// ---------------------------------------------
	public void intiateContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactCreationForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("email"), contact.getEmail());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		selectByText(By.name("new_group"), contact.getNew_group());
		type(By.name("byear"), contact.getByear());
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
	}

	public void submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
	}

	public void initContactEdit(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	}

	public void submitContactDelete(ContactData contact) {
		contact.setId(driver.findElement(By.xpath("//input[@name='id']")).getAttribute("value"));
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
	}

	public void submitContactUpdate(ContactData contact) {
		contact.setId(driver.findElement(By.xpath("//input[@name='id']")).getAttribute("value"));
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
	}

}
