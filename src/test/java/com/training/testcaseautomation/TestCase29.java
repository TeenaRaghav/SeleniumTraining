package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCase29 extends BaseTest {
	static void selectViewFromContactsTab() {
		Select mycontacts = new Select(driver.findElement(By.xpath("//select[@id=\"fcf\"]")));
		mycontacts.selectByVisibleText("My Contacts");
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		selectViewFromContactsTab();
		System.out.println("TestCase29 is passed	");
	}
}
