package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase10 extends BaseTest{
	static void logInToApplication() {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		String urlbeforelogin = driver.getCurrentUrl();
		System.out.println(urlbeforelogin);
		
//		username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("teena@raghav.com");
//		password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("pritishtina@1");
//		login
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	
	}
public static void main(String[] args) throws InterruptedException {
	getDriver();
	logInToApplication();
	
	clickOnUserMenu();
	logout();

	String actualUrl = driver.getCurrentUrl();
	System.out.println(actualUrl);
	System.out.println("TestCAse10 is passed.");

	Thread.sleep(4000);
	driver.close();
}
}
