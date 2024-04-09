package com.training.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAlertGetText {
	static WebDriver driver;
	
	
	static void logInToApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 driver.get("https://selenium-prd.firebaseapp.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(4000);
		 WebDriverWait wait = new WebDriverWait(driver,10);
//		 enter the username
		 WebElement username = driver.findElement(By.id("email_field"));
		 username.sendKeys("admin123@gmail.com");
		 wait.until(ExpectedConditions.visibilityOf(username));

//		 Thread.sleep(4000);
//		 enter the password
		 WebElement password = driver.findElement(By.id("password_field"));
		 password.sendKeys("admin");
		 Thread.sleep(4000);
//		 perform click operation on login button
		 WebElement login = driver.findElement(By.xpath("//button[text() = 'Login to Account']"));
		 login.click();
		 Thread.sleep(7000);
	}
	
	public static void main(String[] args) throws InterruptedException {
		logInToApplication();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(4000);
		driver.quit();
		
	}
	
}
