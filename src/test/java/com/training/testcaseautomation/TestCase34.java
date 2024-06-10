package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase34 extends BaseTest{
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		hometab();
//		validation
//		 displaying of home page
		String actualusernameonhomepage = driver.findElement(By.xpath("(//a[contains(text(),\"Teena Raghav\")])[1]")).getText();
		String expectedusername = "Teena Raghav";
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "https://pcs4-dev-ed.develop.my.salesforce.com/home/home.jsp";
		
		
		if (actualurl.equals(expectedurl) && actualusernameonhomepage.equals(expectedusername)) {
			System.out.println("Firstname and Lastname is displayed");
		}
//		click on the first and last name link
		driver.findElement(By.xpath("(//a[contains(text(),\"Teena Raghav\")])[1]")).click();
//		we are on myprofile page
//		checking first and last name
		String actualusernamelink=driver.findElement(By.id("tailBreadcrumbNode")).getText();
//		System.out.println(actualusernamelink);
		String expectedusernamelink = "Teena Raghav";

//		validating the currentpage is same as my profile page
		
		clickOnUserMenu();
		WebElement myprofilebtn = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myprofilebtn.click();
		String actualusernameonmyprofilepage=driver.findElement(By.id("tailBreadcrumbNode")).getText();
		if(actualusernameonhomepage.equals(actualusernameonmyprofilepage)){
			System.out.println("The Homepage is same as My profilepage. ");
			System.out.println("TestCase 34 is passed.");
			}
		
		driver.close();
		
		
	}

}
