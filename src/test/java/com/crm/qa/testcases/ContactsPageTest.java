package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		tu = new TestUtil();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = -1)
	public void verifyContactsLabelTest() {
		tu.switchToFrame();
		cp = hp.clickOnContactsLink();
		Assert.assertTrue(cp.verifyContactsLabel(), "Contact is missing on the page ");
	}

	@Test(priority = 0)
	public void selectMultipleContactsTest() {
		tu.switchToFrame();
		cp = hp.clickOnContactsLink();
		cp.selectContactsByName("Khushbu Joshi");
		cp.selectContactsByName("Jay Bhatt");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "getCRMTestData")
	public void validateCreateNewContacts(String Title, String FirstName, String LastName, String Company) {
		tu.switchToFrame();
		hp.clickOnNewContactLink();
		cp.createNewContacts(Title, FirstName, LastName, Company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
