package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase23 extends BaseTest {
	static void viewDropdownOnLeadsPage() {
		Select viewelement = new Select(driver.findElement(By.xpath("//select[@name=\"fcf\"]")));
		viewelement.selectByVisibleText("Today's Leads");
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		leadsTab();
		viewDropdownOnLeadsPage();
		clickOnUserMenu();
		logout();
		logInToApplication();
		leadsTab();
//		click on go button
		WebElement gobtn = driver.findElement(By.xpath("(//input[@class=\"btn\"])[2]"));
//		gobtn.isEnabled();
		gobtn.click();
		System.out.println("TestCase23 is passed.");
		Thread.sleep(4000);
		driver.close();
	}
}
