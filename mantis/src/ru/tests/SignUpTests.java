package ru.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.fw.User;

public class SignUpTests extends Testbase {

	private User user;

	@BeforeClass
	public void createMailUser() {
		user = new User().setLogin("user6");
		user.setEmail(user.getName() + "@localhost").setPassword("123456");
		if (!manager.getJamesHelper().doesUserExist(user.getName()))
			manager.getJamesHelper().createUser(user.getName(), user.getPassword());
	}

	@AfterClass
	public void deleteMailUser() throws Exception {
		if (manager.getJamesHelper().doesUserExist(user.getName()))
			manager.getJamesHelper().deleteUser(user.getName());
		if (manager.getAccountHelper().doesUserExist(user))
			manager.getAccountHelper().deleteUser(user);
	}

	@Test
	public void newUserShouldSingUp() throws Exception {
		Assert.assertTrue(!manager.getAccountHelper().doesUserExist(user),
				"User <" + user.getName() + "> should NOT exist before this test-case");
		Assert.assertTrue(manager.getAccountHelper().signUp(user), "New user <" + user.getName() + "> can't sign up");
		Assert.assertTrue(manager.getAccountHelper().doesUserExist(user),
				"User <" + user.getName() + "> doesn't exists after sign up");
	}

	@Test(dependsOnMethods = "newUserShouldSingUp")
	public void existingUserShouldNotSingUp() throws Exception {
		Assert.assertTrue(manager.getAccountHelper().doesUserExist(user),
				"User <" + user.getName() + "> should exist before this test-case");
		Assert.assertTrue(!manager.getAccountHelper().signUp(user),
				"Existing user <" + user.getName() + "> can sign up");
	}

	@Test(dependsOnMethods = "existingUserShouldNotSingUp")
	public void deleteUser() throws Exception {
		Assert.assertTrue(manager.getAccountHelper().doesUserExist(user),
				"<" + user.getName() + "> should exist before this test-case");
		manager.getAccountHelper().deleteUser(user);
		Assert.assertTrue(!manager.getAccountHelper().doesUserExist(user),
				"User <" + user.getName() + "> exists after deleting");
	}
}
