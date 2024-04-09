package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase12 extends BaseTest {
	static void createNewViewInAccountsTab() {
//		click on new view Link
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
//		enter view name
		driver.findElement(By.xpath("//input[@id=\"fname\"]")).sendKeys("Hi Value Costumers346");
//		enter view unique name
		WebElement viewUniqName = driver.findElement(By.xpath("//input[@id=\"devname\"]"));
		viewUniqName.click();
		viewUniqName.clear();
		viewUniqName.sendKeys("dbshebkd");	
//		save
		driver.findElement(By.xpath("//input[@name=\"save\"]")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		accountsTab();
		createNewViewInAccountsTab();
		System.out.println("TestCase12 is passed");

		Thread.sleep(4000);
//		driver.close();
	}
}
