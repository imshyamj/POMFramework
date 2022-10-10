package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
public class RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		WebElement email = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(with(By.tagName("input")).below(email));
		password.sendKeys("hdhfkdfk");
		
	}

}
