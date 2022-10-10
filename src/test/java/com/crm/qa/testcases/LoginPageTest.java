package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		lp = new LoginPage();	
	}
	
	@Test(priority=-1)
	public void loginPageTitleTest(){
		String loginPagetitle = lp.validateLoginPageTitle();
		Assert.assertEquals(loginPagetitle, "Free CRM - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority=0)
	public void crmLogoImageTest(){
		boolean flag = lp.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest(){
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
