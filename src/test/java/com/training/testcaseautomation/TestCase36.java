package com.training.testcaseautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase36 extends BaseTest{
	static void customizeMyTab() {
//		click on the + button
		driver.findElement(By.id("AllTab_Tab")).click();
//	click on customize my tabs button
		driver.findElement(By.className("btnImportant")).click();
//	select tab from selected tabs area 
		driver.findElement(By.xpath("//option[contains(text(),'Leads')]")).click();
//		click on remove button
		driver.findElement(By.id("duel_select_0_left")).click();
//	validate removed tab displayed in available tabs section

		Select drp = new Select(driver.findElement(By.xpath("//select[@id=\"duel_select_0\"]")));

		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals("Leads")) {
				System.out.println("Removed Tab is moved to Available tab section.");
				break;
			}
		}
//	click on save button
		driver.findElement(By.xpath(" //input[@value=\" Save \"]")).click();
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		customizeMyTab();
		clickOnUserMenu();
		logout();
		logInToApplication();
		System.out.println("TestCase36 is passed.");
		
	}

}
