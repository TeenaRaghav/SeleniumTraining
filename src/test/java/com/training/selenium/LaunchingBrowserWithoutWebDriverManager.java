package com.training.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingBrowserWithoutWebDriverManager {
	public static WebDriver driver;

	public static void main(String[] args) {
//		launch the browser without webDriverManager
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\browsers\\chromedriver-win64\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.close();
		
	}

}
