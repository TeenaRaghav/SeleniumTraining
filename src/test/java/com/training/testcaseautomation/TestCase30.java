package com.training.testcaseautomation;

import org.openqa.selenium.By;

public class TestCase30 extends BaseTest {
	static void recentContact() {
//		click on recent contact
		driver.findElement(By.xpath("//table[@class=\"list\"]/tbody/tr[2]/th/a")).click();

	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		recentContact();
//		validation
		String actualheading = driver.findElement(By.className("topName")).getText();
		String expectedheading="Indian";
		if(actualheading.equals(expectedheading)) {
			System.out.println("TestCase30 is passed.");
		}
		driver.close();
	}
	
}
