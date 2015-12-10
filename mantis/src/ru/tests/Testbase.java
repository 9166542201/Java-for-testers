package ru.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.fw.Manager;

public class Testbase {
	protected static Manager manager;

	@BeforeTest
	public void setUp() throws Exception {
		String config = System.getProperty("config", "src/default.properties");
		Properties properties = new Properties();
		FileReader reader = new FileReader(new File(config));
		properties.load(reader);
		manager = new Manager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		manager.stop();
	}

}
