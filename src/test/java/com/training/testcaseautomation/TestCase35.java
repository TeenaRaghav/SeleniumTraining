package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase35 extends BaseTest {
	public static void editButtonNextToContact() {
		WebElement edit = driver.findElement(By.xpath("//a[@class=\"contactInfoLaunch editLink\"]"));
		edit.click();
		
	}
	public static void aboutInEditBtnNextToContact() {
//		locating frame
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
//		about tab
		driver.findElement(By.id("aboutTab")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@class = 'lastName zen-inputFull zen-input']"));
		lastname.clear();
		lastname.sendKeys("Abcd");
		WebElement saveallbtn = driver.findElement(By.xpath("//input[@class ='zen-btn zen-primaryBtn zen-pas']"));
		saveallbtn.click();	
	}
public static void main(String[] args) throws InterruptedException {
	getDriver();
	logInToApplication();
	hometab();
//	click on the first and last name link
	driver.findElement(By.xpath("(//a[contains(text(),\"Teena singh\")])[1]")).click();
	editButtonNextToContact();
	 aboutInEditBtnNextToContact();
//	 validate lastname is edited
	 String actualusername =driver.findElement(By.id("tailBreadcrumbNode")).getText();
	 String expectedUsername = "Teena Abcd ";
	 if(actualusername.equals(expectedUsername)) {
		 System.out.println("Testcase35 is passed.");
	 }
} 
}
