package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	protected void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/group.php");
	}

	//TestOfGroupCreationMethods
	protected void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	protected void initiateGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	protected void fillGroupCreationForm(DataOfGroupCreation groupData) {
		driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(groupData.group_name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(groupData.group_header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(groupData.group_footer);
	}

	protected void submitGroupCreation() {
		submitContactCreation();
	}

	protected void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	// TestOfContactCreationMethods
	protected void intiateContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void fillContactCreationForm(DataOfContactCreation contactData) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contactData.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contactData.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contactData.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contactData.home);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contactData.mobile);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contactData.work);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contactData.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contactData.email2);
		if (contactData.bday!="") new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.bday);
		if (contactData.bmonth!="") new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.bmonth);
		if (contactData.new_group!="") new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.new_group);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contactData.byear);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contactData.address2);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contactData.phone2);
	}

	protected void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}
	
}
