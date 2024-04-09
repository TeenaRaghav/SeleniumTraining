package com.training.testcaseautomation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testcase37 extends BaseTest{
	
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		hometab();
//		current date display
		WebElement currentdate = driver.findElement(By.xpath("//a[contains(text(),'Friday March 29, 2024')]"));
		System.out.println("Today's Date is :" + currentdate.getText());
		System.out.println("current date is diplayed:" + currentdate.isDisplayed());
//		click on the current date link
		currentdate.click();
//		click on 8pm link
		driver.findElement(By.id("p:f:j_id25:j_id61:28:j_id64")).click();
//		click on subject combo icon
		driver.findElement(By.className("comboboxIcon")).click();
		Thread.sleep(4000);
//		switch to window
		String parentWindow=  driver.getWindowHandle();
		Set<String> listofhandles = driver.getWindowHandles(); 
		for(String handle : listofhandles) {
			if(!handle.equals(parentWindow)) {
			driver.switchTo().window(handle);
//		click on other
		driver.findElement(By.xpath("//a[contains(text(),'Other')]")).click();		
			}
		}
//		switch back to parent window
		driver.switchTo().window(parentWindow);
//		click on the End time field
		driver.findElement(By.xpath("//input[@id=\"EndDateTime_time\"]")).click();
//		select 9pm from the dropdown
		driver.findElement(By.id("timePickerItem_42")).click();
//		click on save button
		driver.findElement(By.xpath("(//input[@value=\" Save \"])[1]")).click();

	}

}
