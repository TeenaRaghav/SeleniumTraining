package com.training.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicsDay1 {
	public static void main(String[] args) throws InterruptedException {
//		launch the browser
		WebDriverManager.chromedriver().setup();

//		create an object of webDriver
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

//		enter the url
		driver.get("https://selenium-prd.firebaseapp.com");
//		static wait
		Thread.sleep(5000);

//		locate the element
		WebElement email = driver.findElement(By.id("email_field"));

//	perform action
		email.sendKeys("admin123@gmail.com");
		
//		for password element
		WebElement password = driver.findElement(By.id("password_field"));

//		perform action
		password.sendKeys("admin123");
		

//		for login button
		WebElement login = driver.findElement(By.tagName("button"));
		login.click();
//		delay to close the web page
		Thread.sleep(5000);
		
		driver.close();		
	}

}
