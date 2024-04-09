package com.training.testcaseautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase26 extends BaseTest {
	static void createnewContacts() throws InterruptedException {
//		click on new button
		driver.findElement(By.xpath("//input[@value=\" New \"]")).click();
//		enter last name
		driver.findElement(By.xpath("//input[@id='name_lastcon2']")).sendKeys("Sen");
//		look for account name from lookup icon
		driver.findElement(By.id("con4_lkwgt")).click();
		Thread.sleep(4000);
//		switch to new window
		String parentwindow = driver.getWindowHandle();
		Set<String> listofhandles = driver.getWindowHandles();
		for(String handle : listofhandles) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
//				switch to frame
				WebElement frame = driver.findElement(By.xpath("//frame[@id=\"resultsFrame\"]"));
				driver.switchTo().frame(frame);
//				select account 
				driver.findElement(By.xpath("//a[contains(text(),'Global Media')]")).click();
			}
		}
//		switch back to parent window
		driver.switchTo().window(parentwindow);
//		click on save button
		driver.findElement(By.xpath("(//input[@value=\" Save \"])[1]")).click();

	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		createnewContacts();
		System.out.println("TestCase 26 is passed.");
		Thread.sleep(4000);
		driver.close();
	}

}
