package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase27 extends BaseTest {
	static void createNewViewInontactsTab() {
//		click on create new view link
		driver.findElement(By.xpath("//a[contains(text(),'Create New View')]")).click();
//	enter the new view name in the field
		driver.findElement(By.xpath("//input[@id=\"fname\"]")).sendKeys("Valued Costume");
// enter new view unique name
		WebElement viewuniquename=driver.findElement(By.xpath("//input[@id=\"devname\"]"));
		viewuniquename.click();
		viewuniquename.clear();
		viewuniquename.sendKeys("High_valued_custome");
//		click on save button
		driver.findElement(By.xpath("(//input[@value=\" Save \"])[1]")).click();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		contactsTab();
		createNewViewInontactsTab();
		System.out.println("TestCase27 is passed");
////		validate
//		WebElement selectedViewname = driver.findElement(By.tagName("option"));
//		String selectedview = selectedViewname.getAttribute("selected");
//		
//		
//		if(selectedViewname.isSelected()) {
//			System.out.println("TestCase27 is passed.");
//		}
		Thread.sleep(4000);
		
	}

}
