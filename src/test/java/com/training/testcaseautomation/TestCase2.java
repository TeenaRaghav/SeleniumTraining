package com.training.testcaseautomation;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 extends BaseTest {
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		String actualtitle = driver.getTitle();
		String expectedtitle="Home Page ~ Salesforce - Developer Edition";
		if(actualtitle.equals(expectedtitle)) {
			System.out.println("TestCase 2 is passed.");
		}
		Thread.sleep(2000);
		driver.close();
	}
}
