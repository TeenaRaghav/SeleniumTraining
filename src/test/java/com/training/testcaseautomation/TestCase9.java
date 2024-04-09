package com.training.testcaseautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase9 extends BaseTest {
	static WebElement consolebutton;
	static void developerConsole() {
		 consolebutton = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
			consolebutton .click();
			
	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		Thread.sleep(4000);
		clickOnUserMenu();
		developerConsole();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> listofhandles = driver.getWindowHandles();
		for(String handle : listofhandles) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				System.out.println("TestCase9 is passed.");
			}
			
		}
		
		driver.quit();
	}
}
