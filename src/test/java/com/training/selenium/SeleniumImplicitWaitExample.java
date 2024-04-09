package com.training.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumImplicitWaitExample {

	public static void main(String[] args) throws InterruptedException {
//			launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
//	declaring implicit wait at the driver level
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		// find the element
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		searchbox.sendKeys("selenium");

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"))
				.sendKeys(Keys.RETURN);
//			WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
//			searchButton.click();

		driver.close();
	}
}
