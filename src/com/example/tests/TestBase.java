package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			GroupData group = new GroupData();
			group.group_name = generateRandomString();
			group.group_header = generateRandomString();
			group.group_footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<>();
		for (int i = 0; i < 1; i++) {
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString();
			contact.lastname = generateRandomString();
			contact.address = generateRandomString();
			contact.address2 = generateRandomString();
			contact.email = generateRandomString();
			contact.email2 = generateRandomString();
			contact.home = generateRandomString();
			contact.mobile = generateRandomString();
			contact.phone2 = generateRandomString();
			contact.work = generateRandomString();

			contact.bday = generateRandomDayOfBirth();
			contact.byear = generateRandomYearOfBirth();
			contact.bmonth = generateRandomMonthOfBirth();

			contact.new_group = null;

			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0)
			return "";
		else if (rnd.nextInt(2) == 0)
			return "test" + rnd.nextInt(2);
		else
			return "Test" + rnd.nextInt(2);
	}

	public String generateRandomDayOfBirth() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0)
			return null;
		else
			return "1";
	}

	public String generateRandomYearOfBirth() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0)
			return null;
		else
			return "2000";
	}

	public String generateRandomMonthOfBirth() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0)
			return null;
		else
			return "January";
	}

}
