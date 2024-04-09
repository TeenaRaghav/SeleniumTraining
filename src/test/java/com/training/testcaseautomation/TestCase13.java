package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase13 extends BaseTest {
	static void editViewFromAccountsPage() {
//		select view name  High Value Customers View from dropdown
		WebElement viewDropdown = driver.findElement(By.xpath("//select[@name='fcf']"));
		System.out.println(viewDropdown.isEnabled());
		Select view = new Select(viewDropdown);
		view.selectByValue("00Bak000004s8sr");
//		click on edit link
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
//		change the view name to new view name
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("High Value Customers121");
//		select in filter dropdowns
//		fields
		Select field = new Select(driver.findElement(By.xpath("//select[@id=\"fcol1\"]")));
		field.selectByVisibleText("Account Name");
//		operator
		Select operator = new Select(driver.findElement(By.xpath("//select[@id=\"fop1\"]")));
		operator.selectByVisibleText("contains");
//		value
		WebElement value = driver.findElement(By.xpath("//input[@id=\"fval1\"]"));
		value.clear();
		value.sendKeys("a");
//		from select field add Last Activity to display
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"colselector_select_0\"]")));
		// Scroll down by a certain pixel value
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 500)");
					
		Select selectField = new Select(driver.findElement(By.xpath("//select[@id=\"colselector_select_0\"]")));
		selectField.selectByVisibleText("Last Activity");
//		press add button
		driver.findElement(By.xpath("//img[@class=\"rightArrowIcon\"]")).click();
//		press save button
		driver.findElement(By.xpath("//input[@value=\" Save \"]")).click();
				
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		accountsTab();
		editViewFromAccountsPage();

		System.out.println("TestCase 13 is passed.");
		Thread.sleep(4000);
		driver.close();

	}

}
