package com.training.testcaseautomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase17 extends BaseTest {
	static void createNewopportunity() {
//		click on new button
		driver.findElement(By.xpath("//input[@name=\"new\"]")).click();
//		input opportunity name
		driver.findElement(By.xpath("//input[@id=\"opp3\"]")).sendKeys("Pqrstuv");
//		input account name
		driver.findElement(By.xpath("//input[@id=\"opp4\"]")).sendKeys("MSN & CO");
		
//		input close date
		driver.findElement(By.xpath("//input[@id=\"opp9\"]")).click();
		new WebDriverWait(driver,10)
		.until(ExpectedConditions.visibilityOfElementLocated(By.className("calDays")));
		WebElement monthpicker = driver.findElement(By.id("calMonthPicker"));
		Select selectmonth = new Select(monthpicker);
		selectmonth.selectByValue("2");
		WebElement yearpicker = driver.findElement(By.id("calYearPicker"));
		Select selectyear = new Select(yearpicker);
		selectyear.selectByValue("2023");
//		String monthyearval =driver.findElement(By.className("dateBar")).getText();
//		System.out.println(monthyearval);
//		String month = monthyearval.split(" ")[0].trim();
//		String year = monthyearval.split(" ")[1].trim();
//		while(!month.equals("june") && year.equals("2023"))){
//			driver.findElement(By.xpath("")).click();
//		}
		driver.findElement(By.xpath("//table[@class='calDays']/tbody/tr[4]/td[3]")).click();

//		select stage	
		WebElement stage = driver.findElement(By.xpath("//select[@id=\"opp11\"]"));
		selectOptionsFromDropdown(stage,"Qualification");
//		pobability
		driver.findElement(By.xpath("//input[@id=\"opp12\"]")).click();
//		select lead source
		WebElement leadsource =driver.findElement(By.xpath("//select[@id=\"opp6\"]"));
		selectOptionsFromDropdown(leadsource,"Web");
//		primary campaign source
		driver.findElement(By.id("opp17_lkwgt")).click();
//		switching to new window
//		get parentwindow handle
		String parentwindow = driver.getWindowHandle();
		Set<String> listOfHandles =driver.getWindowHandles();
		
		for(String handle: listOfHandles) {
			if(!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				WebElement frame = driver.findElement(By.xpath("//frame[@id=\"resultsFrame\"]"));
				driver.switchTo().frame(frame);
//				click on campaign link
				driver.findElement(By.xpath("//a[contains(text(),'DM Campaign to Top Customers - Nov 12-23, 2001')]")).click();
			}
		}
		driver.switchTo().window(parentwindow);
//		click on save button
		driver.findElement(By.xpath("//input[@name=\"save\"]")).click();		
	}
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		opportunitiestab();
		createNewopportunity();
//		String pagetitle=driver.findElement(By.xpath("//div[@class=\"content\"]/h2")).getText();
//		if(pagetitle.equals("Pqrst")) {
//			System.out.println("TestCase 17 is passed.");
//		}
		Thread.sleep(4000);
		driver.close();
	}
}
