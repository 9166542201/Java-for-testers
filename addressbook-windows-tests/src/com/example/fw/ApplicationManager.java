package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

	private static ApplicationManager singletone;
	private ContactHelper contactHelper;
	private Properties properties;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;

	public static ApplicationManager getManager() {
		if (singletone == null) {
			singletone = new ApplicationManager();
		}
		return singletone;
	}

	public void setProperties(Properties p) {
		properties = p;
	}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}

	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	}

	public void stop() {
		getProcessHelper().stopAppUnderTest();
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null)
			contactHelper = new ContactHelper();
		return contactHelper;
	}

	public ProcessHelper getProcessHelper() {
		if (processHelper == null)
			processHelper = new ProcessHelper(this);
		return processHelper;
	}

	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null)
			autoItHelper = new AutoItHelper(this);
		return autoItHelper;
	}

}