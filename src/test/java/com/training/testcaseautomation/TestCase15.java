package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase15 extends BaseTest {

	static void createAccountReport() {
//		click on last activity link
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]")).click();
	}

	static void reportOptions() {
//		click on date field dropdown
		driver.findElement(By.xpath("//input[@id=\"ext-gen20\"]")).click();
//		select created date filter
		driver.findElement(By.xpath("//div[contains(text(),'Created Date')]")).click();
//		select date in from field
		driver.findElement(By.xpath("//img[@id=\"ext-gen152\"]")).click();
//		select todays date
		driver.findElement(By.xpath("//span[contains(text(),'24')]")).click();
//		select date in To field
		driver.findElement(By.id("ext-gen154")).click();
//		sendKeys("4/2/2024");
//		select todays date
		driver.findElement(By.xpath("(//button[contains(text(),'Today')])[2]")).click();
//		click on save button
		driver.findElement(By.xpath("//button[@id=\"ext-gen49\"]")).click();
//		enter report name
		driver.findElement(By.xpath("//input[@id=\"saveReportDlg_reportNameField\"]")).sendKeys("abcdefgh");
//		enter report unique name
		driver.findElement(By.xpath("//input[@id=\"saveReportDlg_DeveloperName\"]")).click();
// 		click on save and run report button	
		driver.findElement(By.xpath("//table[@id=\"dlgSaveAndRun\"]/tbody/tr[2]/td[2]")).click();

	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		accountsTab();
		createAccountReport();
		reportOptions();
		System.out.println("TestCase 15 is passed.");
		Thread.sleep(4000);
		driver.close();
	}

}
