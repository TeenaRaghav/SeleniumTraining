package com.training.testcaseautomation;

import org.openqa.selenium.By;

public class TestCase31 extends BaseTest {
	static void createNewViewInContactsTab() {
//		click on the link
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
//		enter view unique name
		driver.findElement(By.xpath("//input[@id='devname']")).sendKeys("EFGH");
//		click on save button
		driver.findElement(By.xpath("(//input[@value=\" Save \"])[1]")).click();

	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		createNewViewInContactsTab();
//		validate
		String actualtext = driver.findElement(By.xpath("//div[contains(text(),' You must enter a value')]")).getText();
		System.out.println(actualtext);
		String expectedtext="Error: You must enter a value";
		if(actualtext.equals(expectedtext)) {
			System.out.println("TestCase31 is passed.");
		}
		
		Thread.sleep(4000);
	}
}
