package com.training.testcaseautomation;

import org.openqa.selenium.By;

public class TestCase18 extends BaseTest{
	static void opportunityPipelineLink() {
		driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]")).click();
//		opportunity pipeline page is displayed with opportunities pipelined
		String titleOFPage=driver.findElement(By.xpath("//div[@class=\"content\"]/h1")).getText();
		if(titleOFPage.equals("Opportunity Pipeline")) {
			System.out.println(titleOFPage+ " page is displayed with opportunity pipelined.");
			System.out.println("TestCase18 is passed.");
		}
	}
	public static void main(String[] args) throws InterruptedException  {
		getDriver();
		logInToApplication();
		opportunitiestab();
		opportunityPipelineLink();
		driver.close();
		
	}

}
