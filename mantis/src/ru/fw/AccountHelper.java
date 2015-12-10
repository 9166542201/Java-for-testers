package ru.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AccountHelper {
	protected Manager manager;
	protected WebDriver driver;

	public AccountHelper(Manager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

	public boolean signUp(User user) throws Exception {
		driver.get("http://localhost/mantisbt-1.2.19/signup_page.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user.getName());
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(user.getEmail());
		driver.findElement(By.cssSelector("input.button")).click();
		try {
			driver.findElement(By.linkText("Proceed")).click();
		} catch (NoSuchElementException e) {
			return false;
		}
		Thread.sleep(30000);
		Msg msg = manager.getMailHelper().getNewMail(user.getName(), user.getPassword());
		String s = msg.getConfirmationLink();
		System.out.println("link=" + s);
		 driver.get(s);
		 driver.findElement(By.name("password")).clear();
		 driver.findElement(By.name("password")).sendKeys(user.getPassword());
		 driver.findElement(By.name("password_confirm")).clear();
		 driver.findElement(By.name("password_confirm")).sendKeys(user.getPassword());
		 driver.findElement(By.cssSelector("input.button")).click();
		 Thread.sleep(5000);
		return true;
	}

	public void deleteUser(User user) throws Exception {
		driver.get("http://localhost/mantisbt-1.2.19/login_page.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("administrator");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("root");
		driver.findElement(By.cssSelector("input.button")).click();
		driver.findElement(By.linkText("Manage Users")).click();
		driver.findElement(By.linkText(user.getName())).click();
		driver.findElement(By.xpath("//input[@value='Delete User']")).click();
		driver.findElement(By.cssSelector("input.button")).click();
		driver.findElement(By.linkText("Proceed")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	public boolean logInUser(User user) {
		driver.get("http://localhost/mantisbt-1.2.19/login_page.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user.getName());
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(user.getPassword());
		driver.findElement(By.cssSelector("input.button")).click();
		return isElementPresent(By.xpath("//td[@class='login-info-left']//span[.='" + user.getName() + "']"));
	}

	public boolean doesUserExist(User user) {
		driver.get("http://localhost/mantisbt-1.2.19/login_page.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("administrator");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("root");
		driver.findElement(By.cssSelector("input.button")).click();
		driver.findElement(By.linkText("Manage Users")).click();
		boolean present = isElementPresent(By.linkText(user.getName()));
		driver.findElement(By.linkText("Logout")).click();
		return present;
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}