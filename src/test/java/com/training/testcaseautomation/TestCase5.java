package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5 extends TestCase3 {
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 return driver;
	}
	
	 static void logInToApplication() throws InterruptedException {
//		username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("123");
		Thread.sleep(4000);
//		password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("22131");

//		login
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		Thread.sleep(4000);
	//print error message
		WebElement error = driver.findElement(By.id("error"));
		String actualErrorText = error.getText();
		String expectedErrorText = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(actualErrorText.equals(expectedErrorText)) {
		System.out.println("Testcase is Passed : " + actualErrorText);
		}else {
			System.out.println("Testcase is failed.");
		}
	}
	
public static void main(String[] args) throws InterruptedException {
	 getDriver();
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	
	logInToApplication();
	Thread.sleep(2000);
	driver.close();
}
}
