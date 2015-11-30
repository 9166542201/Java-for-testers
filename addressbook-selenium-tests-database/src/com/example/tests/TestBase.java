package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String config = System.getProperty("config", "default.properties");
		Properties properties = new Properties();
		FileReader reader = new FileReader(new File(config));
		properties.load(reader);
		System.out.println(properties.getProperty("browser"));
		app = new ApplicationManager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapForDataProvider(generateRandomGroups(1));
	}

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		// return wrapForDataProvider(loadGroupsFromCsvFile(new File("groups.txt")));
		return wrapForDataProvider(loadGroupsFromXmlFile(new File("groups.xml")));
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapForDataProvider(generateRandomContacts(1));
	}

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		//return wrapForDataProvider(loadContactsFromCsvFile(new File("contacts.txt")));
		return wrapForDataProvider(loadContactsFromXmlFile(new File("contacts.xml")));
	}

	private Iterator<Object[]> wrapForDataProvider(@SuppressWarnings("rawtypes") List objects) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (Object object : objects)
			list.add(new Object[] { object });
		return list.iterator();
	}

	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0)
			return "";
		else if (rnd.nextInt(2) == 0)
			return "test" + rnd.nextInt(2);
		else
			return "Test" + rnd.nextInt(2);
	}
}
