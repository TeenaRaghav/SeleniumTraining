package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase25 extends BaseTest {

	static void createNewLead() {
//		click on new button
		driver.findElement(By.xpath("//input[@title='New']")).click();
//		enter last name
		driver.findElement(By.xpath("//input[@id=\"name_lastlea2\"]")).sendKeys("ABCD");
//		enter company name
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ABCD");
//		click on save button
		driver.findElement(By.xpath("(//input[@value=' Save '])[1]")).click();

	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		leadsTab();
		createNewLead();

//	validate
		String pagetitle = driver.findElement(By.className("topName")).getText();
		if (pagetitle.equals("ABCD")) {
			System.out.println("Newly lead page is displyed.");
			System.out.println("TestCase 25 is passed.");
		}
		Thread.sleep(4000);
//		driver.close();
	}

}
