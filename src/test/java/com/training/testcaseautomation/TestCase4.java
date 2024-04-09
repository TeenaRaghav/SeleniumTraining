package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4 {
	static WebDriver driver;
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 return driver;
	}
	static void forgotYourPasswordLink() throws InterruptedException {
		Thread.sleep(4000);
		WebElement forgotPasswrd = driver.findElement(By.id("forgot_password_link"));
		forgotPasswrd.click();
		
		WebElement username = driver.findElement(By.xpath("//input[@id = 'un']"));
		username.sendKeys("teena@raghav.com");
		Thread.sleep(4000);
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id = 'continue']"));
		continueBtn.click();
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		getDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		forgotYourPasswordLink();
		Thread.sleep(2000);
		driver.close();
	}
}
