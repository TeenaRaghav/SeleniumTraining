package com.training.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAlerts {
	static WebDriver driver;
	static Actions action;

	static void logInToApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
//		 enter the username
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		Thread.sleep(2000);

//		 enter the password
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		Thread.sleep(4000);
//		 perform click operation on login button
		WebElement login = driver.findElement(By.xpath("//button[text() = 'Login to Account']"));
		login.click();
		Thread.sleep(7000);
	}

	static void hoverToSwitchToTab() {
		WebElement switchto = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		action = new Actions(driver);
		action.moveToElement(switchto).build().perform();
	}

	static void alert() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Alert')]")).click();
		WebElement windowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		windowAlert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement promtAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		promtAlert.click();
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
//		driver.switchTo().alert().sendKeys("Teena");
//		driver.switchTo().alert().accept();
//		Thread.sleep(2000);
		
	}

	public static void main(String[] args) throws InterruptedException {
		logInToApplication();
		hoverToSwitchToTab();
		alert();
		Thread.sleep(2000);
		driver.quit();
	}
}
