package com.training.testcaseautomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver;
	protected WebDriverWait wait;

	static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void goTourl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		System.out.println("browser window is maximized");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshpage() {
		driver.navigate().refresh();
	}

	public String getTextFromElement(WebElement ele, String objectname) {
		String data = ele.getText();
		System.out.println("extracted the text from" + objectname);
		return data;
	}

	public void closeBrowser() {
		driver.close();
		System.out.println("Browser is closed.");
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void clearElement(WebElement ele, String objectname) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(objectname + " is cleared.");
		} else {
			System.out.println(objectname + " element is not displayed.");
		}
	}

	public void enterText(WebElement ele, String data, String objectname) {
		if (ele.isDisplayed()) {
			clearElement(ele, objectname);
			ele.sendKeys(data);
			System.out.println("data is entered in the " + objectname);
		} else {
			System.out.println(objectname + " element is not displayed.");
		}

	}

	static WebElement explicitWait(WebDriver driver, By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		return driver.findElement(locator);
	}

	static void logInToApplication() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
//		username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("teena@raghav.com");
//		password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("pritishtina@1");
//		login
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}

	static void clickOnUserMenu() throws InterruptedException {

		WebElement username = driver.findElement(By.xpath("//div[@id ='userNavButton']"));
		username.click();
		Thread.sleep(4000);
	}

	static void logout() {
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}

	static void accountsTab() {
		driver.findElement(By.id("Account_Tab")).click();
	}

	static void opportunitiestab() {
//		click on opportunities tab
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
	}

	static void leadsTab() {
//		click on leads tab
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	}

	static void selectOptionsFromDropdown(WebElement element, String value) {
		Select drp = new Select(element);

		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}
	
	static void contactsTab() {
//		click on contacts tab
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();	
	}
	
	static void hometab() {
		driver.findElement(By.xpath("(//a[contains(text(),'Home')])[1]")).click();
	}

}
