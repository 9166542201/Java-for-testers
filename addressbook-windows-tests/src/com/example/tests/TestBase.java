package com.example.tests;

import static com.example.fw.ApplicationManager.getManager;

import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	@BeforeTest
	@Parameters("config")
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile==null) configFile = "application.properties";
		Properties properties = new Properties();
		properties.load(new FileReader(configFile));
		getManager().setProperties(properties);
		getManager().start();
	}

	@AfterTest
	public void tearDown() throws Exception {
		getManager().stop();
	}

}
