package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {
	static WebDriver driver;
	static Actions action;
static WebDriverWait wait;
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver,10);
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
		password.sendKeys("pritishtina@1");
//		check the remember me checkbox
		WebElement rememberme= driver.findElement(By.xpath("//input[@class ='r4 fl mr8']"));
		if(!rememberme.isSelected()) {
			rememberme.click();
		}
//		login
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}
	
	public static void clickOnUserMenu() throws InterruptedException {
		WebElement usermenu = driver.findElement(By.xpath("//div[@id ='userNavButton']"));
		usermenu.click();
	}
	
	public static void logout() {
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		clickOnUserMenu();
		logout();
	System.out.println("TestCase3 is passed.");	
		driver.close();
	}

}
