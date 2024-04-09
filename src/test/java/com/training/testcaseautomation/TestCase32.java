package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase32 extends BaseTest {
	static void createNewViewInContactsTab() {
//		click on the link
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
//		enter view name
		driver.findElement(By.xpath("//input[@id=\"fname\"]")).sendKeys("ABCD");
//		enter view unique name
		WebElement viewuniquename = driver.findElement(By.xpath("//input[@id='devname']"));
		viewuniquename.click();
		viewuniquename.clear();
		viewuniquename.sendKeys("EFGH");
//		click the cancel button
		driver.findElement(By.xpath("(//input[@value=\"Cancel\"])[1]")).click();
	}

public static void main(String[] args) throws InterruptedException {
	getDriver();
	logInToApplication();
	contactsTab();
	createNewViewInContactsTab();
	System.out.println("TestCase32 is passed.");
	driver.close();
}
}
