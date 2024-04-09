package com.training.selenium;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExplicitWait {
//	generic method for explicit wait
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		return driver.findElement(locator);
		
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		enter the url
		driver.get("https://selenium-prd.firebaseapp.com");


//		locate the element
		WebElement email = driver.findElement(By.id("email_field"));

	//perform action
		email.sendKeys("admin123@gmail.com");
		
		
//		for password element
//		WebElement password = driver.findElement(By.id("password_field"));
		By elelocator = By.id("password_field");
//		perform action
//		password.sendKeys("admin123");
		waitForElementPresent(driver, elelocator, 40000).sendKeys("admin123");

//		for login button
		WebElement login = driver.findElement(By.tagName("button"));
		login.click();

		driver.close();		
		
	}


}
