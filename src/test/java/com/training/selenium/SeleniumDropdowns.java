package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDropdowns {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		Thread.sleep(4000);

//		 enter the username
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		Thread.sleep(4000);
//		 enter the password
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		Thread.sleep(4000);
//		 perform click operation on login button
		WebElement login = driver.findElement(By.xpath("//button[text() = 'Login to Account']"));
		login.click();
		Thread.sleep(7000);

//		 click on the home button
		WebElement home = driver.findElement(By.xpath("//a[text() = 'Home']"));
		home.click();
		Thread.sleep(4000);

		//		identify the dropdown element
		WebElement courseDropdown = driver.findElement(By.xpath("//select[@id='course']"));
		Select course = new Select(courseDropdown);
//		 course.selectByVisibleText("MCA");
//		 course.selectByIndex(2);
		course.selectByValue("bca");
		Thread.sleep(4000);
		driver.close();

	}
}
