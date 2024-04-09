package com.training.selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumXpathExample {
	public static void main(String[] args) throws InterruptedException {
//		launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(4000);

// find the element
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		searchbox.sendKeys("selenium");
//		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).sendKeys(Keys.RETURN);
//		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
//		searchButton.click();
		
		Thread.sleep(4000);
		driver.close();
	}
}
