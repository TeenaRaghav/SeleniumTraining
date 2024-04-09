package com.training.testcaseautomation;

import org.openqa.selenium.By;

public class TestCase19 extends BaseTest {
	static void stuckOpportunityLink() {
//		click on stuck opportunity link
		driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]")).click();
		
		String pageTitle = driver.findElement(By.xpath("//div[@class=\"content\"]/h1")).getText();
		if(pageTitle.equals("Stuck Opportunities")) {
			System.out.println(pageTitle+ " page is displayed with stuck opportunities.");
			System.out.println("TestCase 19 is passed.");
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		opportunitiestab();
		stuckOpportunityLink();
		Thread.sleep(4000);
		driver.close();
	}

}
