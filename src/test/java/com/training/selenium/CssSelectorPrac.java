package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectorPrac {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\browsers\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
//		locate the element

//		WebElement image = driver.findElement(By.className("lnXdpd"));
//		org.openqa.selenium.Dimension imageSize = image.getSize();
//		WebElement link = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a"));
//		link.click();

		WebElement label = driver.findElement(By.cssSelector("label.label.usernamelabel"));
		String spellCheck = label.getText();
		System.out.println(spellCheck);

//		WebElement checkbox = driver.findElement(By.id("rememberUn"));
//		checkbox.click();
		
//		WebElement image = driver.findElement(By.id("logo"));
//		org.openqa.selenium.Point location = image.getLocation();
//		System.out.println(location);

		WebElement textBox = driver.findElement(By.xpath("//input[@name='username']"));
		textBox.sendKeys("teena@gmail.com");
		
		Thread.sleep(4000);
//		WebElement searchButton = driver.findElement(By.name("btnK"));
//		searchButton.click();
		Thread.sleep(4000);
		driver.close();
	}

}
