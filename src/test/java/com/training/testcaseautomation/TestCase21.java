package com.training.testcaseautomation;

import org.openqa.selenium.By;

public class TestCase21 extends BaseTest{
	
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		leadsTab();
		String pageTitle = driver.findElement(By.xpath("//div[@class=\"bPageTitle\"]/div/div/h1")).getText();
		if(pageTitle.equals("Leads")) {
			System.out.println("Leads Homepage is displyed. \nTestCase 21 is passed. ");
		}
		Thread.sleep(4000);
		driver.close();
	}

}
