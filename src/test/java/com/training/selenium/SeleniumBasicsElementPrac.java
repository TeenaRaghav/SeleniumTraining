package com.training.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.WebDriverHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicsElementPrac {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		Thread.sleep(4000);
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("selenium");
		Thread.sleep(4000);
		
		WebElement searchbutton = driver.findElement(By.name("btnK"));
		searchbutton.click();
		Thread.sleep(4000);
		
		driver.close();
	}

}
