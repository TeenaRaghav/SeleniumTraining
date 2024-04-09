package com.training.testcaseautomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase8 extends BaseTest{
	static void mySettings() {
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
//	Personal link
		driver.findElement(By.id("PersonalInfo_font")).click();
//	Login history 
		driver.findElement(By.xpath("//span[contains(text(),'Login History')]")).click();
//		login history for last 6 months link
		driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, "
				+ "including logins from outside the website, such as API logins (Excel .csv file) »')]")).click();
//	display and layout link
		driver.findElement(By.id("DisplayAndLayout_font")).click();
// customize my tab 
		driver.findElement(By.xpath("//span[contains(text(),'Customize My Tabs')]")).click();
//	click on customapp dropdown
		WebElement content=driver.findElement(By.xpath("//select[@id=\"p4\"]"));
		Select appselect = new Select(content);
		appselect.selectByVisibleText("Salesforce Chatter");
//	selecting reports from available tab
		WebElement availabletabs = driver.findElement(By.xpath("//select[@id=\"duel_select_0\"]"));
		Select tab= new Select(availabletabs);
		tab.selectByValue("report");
//		Adding report tab
		driver.findElement(By.className("rightArrowIcon")).click();
//		saving the changes
		driver.findElement(By.xpath("//input[@class=\"btn primary\"]")).click();
//		selecting salesforce chatter page from page drpdown
//		checking for report tab in  salesforce chatter page
		WebElement selectpage1=driver.findElement(By.xpath("//div[@id=\"tsidButton\"]"));
		selectpage1.click();

		driver.findElement(By.xpath("//a[contains(text(),'Salesforce Chatter')]")).click();
		WebElement reports1 = driver.findElement(By.id("report_Tab"));
		if(reports1.isDisplayed()) {
			System.out.println("Reports tab is present in salesforce chatter page.");
		}
		
//		checking for report tab in  sales page
//		selecting sales page from page drpdown
		WebElement selectpage2 =driver.findElement(By.id("tsidLabel"));
		selectpage2.click();

		driver.findElement(By.xpath("//a[contains(text(),'Sales')]")).click();
		WebElement reports2 = driver.findElement(By.id("report_Tab"));
		if(reports2.isDisplayed()) {
			System.out.println("Reports tab is present on sales page.");
		}
		
//		checking for report tab in  Marketing CRM classic page
//		selecting Marketing CRM classic page from page drpdown
		WebElement selectpage3 =driver.findElement(By.id("tsidLabel"));
		selectpage3.click();

		driver.findElement(By.xpath("//a[contains(text(),'Marketing CRM Classic')]")).click();
		WebElement reports3 = driver.findElement(By.id("report_Tab"));
		if(reports3.isDisplayed()) {
			System.out.println("Reports tab is present on Marketing page.");
		}
// 		going back to content page
		WebElement selectcontentpage =driver.findElement(By.id("tsidLabel"));
		selectcontentpage.click();

		driver.findElement(By.xpath("//a[contains(text(),'Content')]")).click();
	}
	
	static void emailLinkSettings() {
//		clicking on My setting
		driver.findElement(By.xpath("//a[contains(text(),'My Settings')]")).click();
//		clicking on Email 
		driver.findElement(By.id("EmailSetup_font")).click();
//		clicking on My email settings
		driver.findElement(By.id("EmailSettings_font")).click();
//		enter email name 
		WebElement emailnameInput=driver.findElement(By.xpath("//input[@id=\"sender_name\"]"));
		emailnameInput.clear();
		emailnameInput.sendKeys("TeenaRTomar");
//		enter email address 
		WebElement emailaddInput=driver.findElement(By.xpath("//input[@id=\"sender_email\"]"));
		emailaddInput.clear();
		emailaddInput.sendKeys("etvksj@djbjd.com");
//		Automatic BCC radio button
		WebElement yesBtn = driver.findElement(By.xpath("//input[@id=\"auto_bcc1\"]"));
		if(!yesBtn.isSelected()) {
			yesBtn.click();
		}else {
			System.out.println("yes button is already selected.");
		}
//		save the changes
		WebElement saveBtn = driver.findElement(By.xpath("//input[@class=\"btn primary\"]"));
		saveBtn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	static void calendarAndReminders(){
//		clicking on calendars and reminders
		driver.findElement(By.id("CalendarAndReminders_font")).click();
		
//		clicking on activity reminders
		driver.findElement(By.xpath("//a[@id=\"Reminders_font\"]")).click();
//		click on test reminder button
		driver.findElement(By.id("testbtn")).click();
		
		String titleofPopUpWindow = driver.getTitle();
		if(titleofPopUpWindow.equals("Activity Reminders ~ Salesforce - Developer Edition"))
		System.out.println("The testcase 8 is passed.");
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		clickOnUserMenu();
		mySettings();	
		clickOnUserMenu();
		emailLinkSettings();
		calendarAndReminders();
		Thread.sleep(4000);
		driver.quit();
	}

}
