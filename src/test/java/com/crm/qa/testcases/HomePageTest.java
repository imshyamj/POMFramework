package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	DealsPage dp;
	TasksPage tp;

	public HomePageTest() {
		super();
	}

	// Test cases should be independent
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		tu = new TestUtil();
		cp = new ContactsPage();
		dp = new DealsPage();
		tp = new TasksPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority=-1)
	public void homePageTitleTest() {
		String homePagetitle = hp.validateHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO", "Home Page title is not correct");
	}
	
	@Test(priority=0)
	public void verifyUserLabelTest(){		
		tu.switchToFrame();
		boolean flag = hp.verifyCorrectUserLabel();
		Assert.assertTrue(flag);
		// Assert.assertTrue(hp.verifyCorrectUserLabel());		Another way to code it
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest() {
		tu.switchToFrame();
		cp=hp.clickOnContactsLink();
	}
	
	@Test(priority=2)
	public void verifyDealsLinkTest() {
		tu.switchToFrame();
		dp=hp.clickOnDealssLink();
	}
	
	@Test(priority=3)
	public void verifyTasksLinkTest() {
		tu.switchToFrame();
		tp=hp.clickOnTasksLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
