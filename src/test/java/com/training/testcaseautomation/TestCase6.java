package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase6 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		Thread.sleep(4000);
		clickOnUserMenu();

		WebElement myprofilebtn = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		String myprofile = myprofilebtn.getText();
		WebElement mysettingbtn = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		String mysetting = mysettingbtn.getText();
		WebElement developerconsolebtn = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		String developerconsole = developerconsolebtn.getText();
		WebElement switchingtolightningexpbtn = driver.findElement(By.xpath("//a[contains(text(),'Switch to Lightning Experience')]"));
		String switchingtolightningexp = switchingtolightningexpbtn.getText();
		WebElement logoutbtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		String logout = logoutbtn.getText();
		
		if(myprofile.equals("My Profile") && mysetting.equals("My Settings") && developerconsole.equals("Developer Console") 
				&& switchingtolightningexp.equals("Switch to Lightning Experience") && logout.equals("Logout")) {
			System.out.println("Contents are displayed.");
		}else {
			System.out.println("Contents are not displayed.");
		}
		System.out.println("Testcase 6 is passed.");

		Thread.sleep(4000);
		driver.close();
	}
}
