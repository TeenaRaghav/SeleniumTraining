package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFrame {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.globalsqa.com/demo-site/select-elements/");
	WebElement frame = driver.findElement(By.xpath("//iframe[@class ='demo-frame lazyloaded']"));
	driver.switchTo().frame(frame);
	Thread.sleep(1000);
	WebElement item1 = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
	Thread.sleep(2000);
	item1.click();
	Thread.sleep(4000);
	driver.close();
	
}
}
