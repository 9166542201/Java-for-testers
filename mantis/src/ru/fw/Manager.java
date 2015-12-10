package ru.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Manager {
	public WebDriver driver;
	public String baseUrl;
	private AccountHelper accountHelper;
	private Properties properties;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;

	public Manager(Properties properties) {
		this.properties = properties;
		String browser = getProperty("browser");
		if (browser.equals("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equals("ie"))
			driver = new InternetExplorerDriver();
		else if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else
			throw new Error("Not supported browser " + browser);
		long wait = Long.parseLong(getProperty("wait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	public void stop() {
		driver.quit();
	}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}

	public AccountHelper getAccountHelper() {
		if (accountHelper == null)
			accountHelper = new AccountHelper(this);
		return accountHelper;
	}

	public MailHelper getMailHelper() {
		if (mailHelper == null)
			mailHelper = new MailHelper(this);
		return mailHelper;
	}

	public JamesHelper getJamesHelper() {
		if (jamesHelper == null)
			jamesHelper = new JamesHelper(this);
		return jamesHelper;
	}

}
