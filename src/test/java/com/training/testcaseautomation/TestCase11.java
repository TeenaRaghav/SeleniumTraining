package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestCase11 extends BaseTest {
	static WebElement accountname;

	static void createNewAccount() {
//		click on new button
		driver.findElement(By.xpath("//input[@value=\" New \"]")).click();
//		passing accountname in textbox
		accountname = driver.findElement(By.xpath("//input[@id=\"acc2\"]"));
		accountname.sendKeys("MSNitmjklmno & CO");
//		select type of account from dropdown
		Select type = new Select(driver.findElement(By.id("acc6")));
		type.selectByValue("Technology Partner");
//		select customer priority from dropdown as high
		Select priority = new Select(driver.findElement(By.xpath("//select[@id=\"00Nak0000011psl\"]")));
		priority.selectByValue("High");
//		save
		driver.findElement(By.xpath("(//input[@name=\"save\"])[1]")).click();

	}

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		accountsTab();
		createNewAccount();

		WebElement pageHeading = driver.findElement(By.xpath("//h2[@class=\"topName\"]"));
		String heading = pageHeading.getText();
		System.out.println("New Account page is displayed wih account details :" + heading);
		System.out.println("TestCase11 is passed.");
		Thread.sleep(4000);
		driver.close();
	}

}
