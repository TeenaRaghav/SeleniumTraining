package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase28 extends BaseTest {
	static void filterview() {
//		select recent created option
//		click on selection button
		Select selectfilter = new Select(driver.findElement(By.xpath("//select[@id=\"hotlist_mode\"]")));
		selectfilter.selectByValue("2");
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		filterview();
		System.out.println("TestCase28 is passed.");
		driver.close();
	}
}
