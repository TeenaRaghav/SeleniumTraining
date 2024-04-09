package com.training.testcaseautomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase14 extends BaseTest {
	static Alert alert;
	static void mergeAccounts() {
//		click on merge accounts link
		driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]")).click();
//		enter the account name in the text box
		driver.findElement(By.xpath("//input[@id=\"srch\"]")).sendKeys("MSN");
//		click on find account button
		driver.findElement(By.xpath("//input[@value=\"Find Accounts\"]")).click();
//		unchecking 3rd checkbox
		WebElement accountcheckbox = driver.findElement(By.id("cid2"));
		if(accountcheckbox.isDisplayed()) {
		if(accountcheckbox.isSelected()) {
			accountcheckbox.click();
			}		
		}
//		click on next button
		driver.findElement(By.xpath("//input[@title=\"Next\"]")).click();
//		click on merge button
		driver.findElement(By.xpath("//input[@value=\" Merge \"]")).click();
		driver.switchTo().alert().accept();
	}

	static void findDataintable(int rowid, int colid, String expectedText) {
		WebElement tabledata= driver.findElement(By.xpath("//table[@class=\"list\"]/tbody/tr["+rowid+"]/th["+colid+"]"));
		String actualtext = tabledata.getText();
		
		if(actualtext.equalsIgnoreCase(expectedText)) {
			System.out.println("Merge account is present.");
			System.out.println("TestCase14 is passed.");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		accountsTab();
//		mergeAccounts();
		findDataintable(2,1, "MSN & CO");
		Thread.sleep(4000);		
		driver.close();
	}
}
