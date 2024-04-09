package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumToolTip {
	static WebDriver driver;
	static Actions action;

	static void logIntoApplication() throws InterruptedException {
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

	static void intractionsTab() throws InterruptedException {
		WebElement intractions = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		action = new Actions(driver);
		action.moveToElement(intractions).build().perform();
		Thread.sleep(4000);
	}

	static void tooltip() throws InterruptedException {
		WebElement tooltip = driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]"));
		tooltip.click();
		Thread.sleep(4000);
		WebElement Right = driver.findElement(By.className("tooltipr"));
		action = new Actions(driver);
		action.moveToElement(Right).build().perform();
		WebElement righttooltip = driver.findElement(By.className("tooltiptextr"));
		String actualText = righttooltip.getText();
		String expectedText = "Right";
		if (actualText.equals(expectedText)) {
			System.out.println(actualText);
		} else {
			System.out.println("Actual Text is not Matching with Expected Text");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		logIntoApplication();
		intractionsTab();
		tooltip();
		Thread.sleep(4000);
		driver.close();
	}

}
