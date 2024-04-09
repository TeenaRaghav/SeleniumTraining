package com.training.testcaseautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase38 extends BaseTest {
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		hometab();
//		click on current date link
		WebElement currentdate = driver.findElement(By.xpath("//a[contains(text(),'Friday March 29, 2024')]"));
		currentdate.click();
//		click on 4pm link
		driver.findElement(By.id("p:f:j_id25:j_id61:20:j_id64")).click();
//		click on subject combo icon
		driver.findElement(By.className("comboboxIcon")).click();
		Thread.sleep(4000);
//		switch to window
		String parentWindow=  driver.getWindowHandle();
		Set<String> listofhandles = driver.getWindowHandles(); 
		for(String handle : listofhandles) {
			if(!handle.equals(parentWindow)) {
			driver.switchTo().window(handle);
//			click on other
			driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();			
			}
		}
//		switch back to parent window
		driver.switchTo().window(parentWindow);
//		click on the End time field
		driver.findElement(By.xpath("//input[@id=\"EndDateTime_time\"]")).click();
//		select 7pm from the dropdown
		driver.findElement(By.id("timePickerItem_38")).click();
//		check recurrence field
		driver.findElement(By.xpath("//input[@id=\"IsRecurrence\"]")).click();
//		 select frequency
		driver.findElement(By.xpath("//input[@id=\"rectypeftw\"]")).click();
//		enter end date
		driver.findElement(By.xpath("//input[@id=\"RecurrenceEndDateOnly\"]")).click();
//		select date from calender of 2 weeks from current date
//		changing month
		driver.findElement(By.className("calRight")).click();
//		select date
		driver.findElement(By.xpath("//table[@class=\"calDays\"]/tbody/tr[3]/td[6]")).click();
//		click on save button
		driver.findElement(By.xpath("(//input[@value=\" Save \"])[1]")).click();
//		click on month view icon
		driver.findElement(By.className("monthViewIcon")).click();
//		validate
		String currentPageTitle = driver.findElement(By.className("pageType")).getText();
		String expectedPage = "Calendar for Teena Abcd - Month View";
		if(currentPageTitle.equals(expectedPage)) {
			System.out.println("TestCase38 is passed");
		}
	
	}

}
