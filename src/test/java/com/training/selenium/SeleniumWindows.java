package com.training.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWindows {
	static WebDriver driver;
	static Actions action;

	static void logInToApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
//		 enter the username
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		Thread.sleep(2000);

//		 enter the password
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		Thread.sleep(4000);

//		 perform click operation on login button
		WebElement login = driver.findElement(By.xpath("//button[text() = 'Login to Account']"));
		login.click();
		Thread.sleep(7000);
	}

	static void switchToTab() {
		WebElement switchto = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		action = new Actions(driver);
		action.moveToElement(switchto).build().perform();

	}

	static void windows() throws InterruptedException {

		WebElement windows = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		windows.click();
		Thread.sleep(2000);

		WebElement newWindow = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/a[2]/button"));
		newWindow.click();
		
//		WebElement newtabWindow = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/a[1]/button"));
//		newWindow.click();// new tab opened

		String parentWindow = driver.getWindowHandle();// to take handle of current window
		System.out.println("parent Window Handle :" + parentWindow);

		Set<String> listOfHandles = driver.getWindowHandles();
		System.out.println("Total number of windows opened currently :" + listOfHandles.size());

		for (String handle : listOfHandles) {
			System.out.println("current window handle: " + handle);
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);// switching to new window
				String url = driver.getCurrentUrl();
				String title = driver.getTitle();
				System.out.println("url : " + url + "Title :" + title);
			}
		}
		driver.switchTo().window(parentWindow);//switching back to parent window
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("url : " + url + " Title :" + title);
	}

	public static void main(String[] args) throws InterruptedException {
		logInToApplication();
		switchToTab();
		windows();
		Thread.sleep(2000);
		driver.quit();
	}
}
