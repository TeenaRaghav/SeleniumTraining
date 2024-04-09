package com.training.testcaseautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase22 extends BaseTest {
	static void viewDropdownOnLeadsPage() {
		Select viewelement = new Select( driver.findElement(By.xpath("//select[@name=\"fcf\"]")));
		List<WebElement> alloptions = viewelement.getOptions();

		for(WebElement option : alloptions ) {
		System.out.println(option.getText());
		}
		System.out.println("TestCase 22 is passed.");		
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		leadsTab();
		viewDropdownOnLeadsPage();
		Thread.sleep(4000);
		driver.close();
	}

}
