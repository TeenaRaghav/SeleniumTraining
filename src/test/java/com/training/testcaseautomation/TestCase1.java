package com.training.testcaseautomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 extends BaseTest {
	static WebDriver driver;
	static Actions action;
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 return driver;
	}
	static void logInToApplication() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	
//		username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("teena@raghav.com");

//		password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
//		login
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
//		error message

		WebElement errormessage = driver.findElement(By.id("error"));
		
		String actualerrorText = errormessage.getText();
		
		String expectederror = "Please enter your password.";
		if(actualerrorText.equals(expectederror)){
		System.out.println("Test case1 is passed");
		}else {
			System.out.println("Fail : Error is not as expected.");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		driver.close();
	}
}
