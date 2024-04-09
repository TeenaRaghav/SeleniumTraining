package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase20 extends BaseTest{
	static void quarterlySummary() {
//		select interval from dropdown
		Select interval1= new Select(driver.findElement(By.xpath("//table[@class=\"opportunitySummary\"]/tbody/tr[1]/td[1]/select")));
		interval1.selectByVisibleText("Current and Next FQ");
//		select open from include
		Select include1 = new Select(driver.findElement(By.xpath("//select[@id=\"open\"]")));
		include1.selectByVisibleText("Open Opportunities");
//		select closed from include
		Select include2 = new Select(driver.findElement(By.xpath("//select[@id=\"open\"]")));
		include2.selectByVisibleText("Closed Opportunities");
//		select closed/won from include
		Select include3 = new Select(driver.findElement(By.xpath("//select[@id=\"open\"]")));
		include3.selectByVisibleText("Closed/Won Opportunities");
//		click on run report  button
		driver.findElement(By.xpath("//input[@value=\"Run Report\"]")).click();
		String pageTitle = driver.findElement(By.xpath("//div[@class=\"content\"]/h1")).getText();
		if(pageTitle.equals("Opportunity Report")) {
			System.out.println(pageTitle+ " page is displayed with search criteria.");
			System.out.println("TestCase 20 is passed.");
		}
	}
public static void main(String[] args) throws InterruptedException {
	getDriver();
	logInToApplication();
	opportunitiestab();
	quarterlySummary();
	driver.close();
}
}
