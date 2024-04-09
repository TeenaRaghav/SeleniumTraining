package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFrameNewExample {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.manage().window().maximize();
		
		String parentWindow=driver.getWindowHandle();
		
		WebElement iframe = driver.findElement(By.xpath("//*[@id=\"post-2632\"]/div[2]/div/div/div[3]/p/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(7000);
		
		WebElement link = driver.findElement(By.xpath("//*[@id=\"subheader\"]/div/div/a[5]"));
		link.click();
		Thread.sleep(4000);
		
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(7000);
		driver.quit();

	}
}
