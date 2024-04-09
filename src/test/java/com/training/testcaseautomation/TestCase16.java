package com.training.testcaseautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase16 extends BaseTest {
	static void opportunitiestab() {
//		click on opportunities tab
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
//	locate the drpdown element
		WebElement opportunitydropdown = driver.findElement(By.xpath("//select[@id=\"fcf\"]"));
		opportunitydropdown.click();
//		get all option within the dropdown
		List<WebElement> options = opportunitydropdown.findElements(By.tagName("option"));
//		expected option texts
		String[] expectedoptions = { "All Opportunities", "Closing Next Month", "Closing This Month",
				"My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private",
				"Recently Viewed Opportunities", "Won" };

//		verify all options are present
		boolean alloptionsarepresent = true;

		for (String expectedoption : expectedoptions) {
			boolean optionFound = false;
			for (WebElement option : options) {
				if (option.getText().equals(expectedoption)) {
					optionFound = true;
					break;
				}
			}
		}
		if (alloptionsarepresent) {
			System.out.println("Testcase 16 is passed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		opportunitiestab();
		driver.close();
	}
}
