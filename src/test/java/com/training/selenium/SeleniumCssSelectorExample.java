package com.training.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumCssSelectorExample {
	public static void main(String[] args) throws InterruptedException {
//		launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		Thread.sleep(4000);

// find the element
		WebElement searchbox = driver.findElement(By.cssSelector("#APjFqb"));
		searchbox.sendKeys("selenium");
		Thread.sleep(4000);
		
		WebElement searchButton = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9.EyBRub > div.aajZCb > div.lJ9FBc > center > input.gNO89b"));
		searchButton.click();
		
		Thread.sleep(4000);
		driver.close();
	}


}
