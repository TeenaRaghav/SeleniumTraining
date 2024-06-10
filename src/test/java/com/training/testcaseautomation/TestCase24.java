package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase24 extends BaseTest {
	static void todaysLeads() {
		Select viewelement = new Select(driver.findElement(By.xpath("//select[@name=\"fcf\"]")));
		viewelement.selectByVisibleText("Today's Leads");
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		leadsTab();
		todaysLeads();
//		validate
		Select selectDropdwn = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		WebElement selectedoption = selectDropdwn.getFirstSelectedOption(); 
		String selectedtext = selectedoption.getText();
//		System.out.println("Selected option: " + selectedtext);
		if(selectedtext.equals("Today's Leads")) {
			System.out.println("TestCase24 is passed.");
		}
		Thread.sleep(4000);
		driver.close();
	}

}
