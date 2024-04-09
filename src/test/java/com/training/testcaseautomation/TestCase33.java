package com.training.testcaseautomation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase33 extends BaseTest{
	static void createNewContacts() throws InterruptedException {
//		click on new button
		driver.findElement(By.xpath("//input[@value=\" New \"]")).click();
//		enter the last name
		driver.findElement(By.xpath("//input[@id=\"name_lastcon2\"]")).sendKeys("Indian");
//		enter the account name
		driver.findElement(By.id("con4_lkwgt")).click();
		Thread.sleep(4000);
		
		String parentwindow = driver.getWindowHandle();
		Set<String> handles =driver.getWindowHandles();
		for(String handle : handles) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
////				enter text in search box
//						driver.findElement(By.xpath("//input[@name=\"lksrch\"][1]")).sendKeys("Global Media");
// 			switch to frame
				WebElement frame= driver.findElement(By.xpath("//frame[@title=\"Results\"]"));
				driver.switchTo().frame(frame);
////				select the account name
				driver.findElement(By.xpath("//a[contains(text(),'Global Media')]")).click();

			}
		}
//		switch back to parentwindow
		driver.switchTo().window(parentwindow);
//		click on save and new button
		driver.findElement(By.xpath("(//input[@name=\"save_new\"])[1]")).click();
	}
	
public static void main(String[] args) throws InterruptedException {
	getDriver();
	logInToApplication();
	contactsTab();
	createNewContacts();
// validatation
	String actualtitle= driver.findElement(By.className("pageType")).getText();
	String expectedtitle= "Contact Edit";
	if(actualtitle.equals(expectedtitle)) {
		System.out.println("TestCase33 is passed");
	}
	Thread.sleep(2000);
	driver.close();
}
}
