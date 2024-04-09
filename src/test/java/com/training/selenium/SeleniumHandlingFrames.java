package com.training.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHandlingFrames {
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
	

	
	WebElement frames = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/div[2]/div/div/div[3]/p/iframe"));
	driver.switchTo().frame(frames);
	WebElement all = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
	Actions action = new Actions(driver);
	action.moveToElement(all).build().perform();
	Thread.sleep(4000);
	WebElement automation = driver.findElement(By.xpath("//div[contains(text(),'Performance Testing')]"));
	Thread.sleep(4000);
	
	// Scroll down by a certain pixel value
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0, 500)");
	
	/*
	 * The JavascriptExecutor interface in Selenium WebDriver allows you to execute
	 * JavaScript code within the context of the currently selected frame or window.
	 * This interface provides methods to execute JavaScript code and interact with
	 * the DOM (Document Object Model) of the web page directly, which can be useful
	 * for various purposes in web automation.
	 */
	/*
	 * Scrolling: You can use JavaScript to scroll the web page vertically or
	 * horizontally. For example, to scroll to a specific element:
	 *  WebElement element = driver.findElement(By.id("element-id")); 
	 *  JavascriptExecutor js = ((JavascriptExecutor) driver)
	 *  js.executeScript("arguments[0].scrollIntoView(true);", element);
	 */
	/*
	 * Scroll down by a certain pixel value 
	 * JavascriptExecutor js =(JavascriptExecutor) driver;
	 *  js.executeScript("window.scrollBy(0, 500)");
	 */	
	/*
	 * Scroll up by a certain pixel value 
	 * JavascriptExecutor js =(JavascriptExecutor) driver; 
	 * js.executeScript("window.scrollBy(0, -500)");
	 */
	


	automation.click();
	
	Thread.sleep(4000);
	driver.quit();
	
}
}
