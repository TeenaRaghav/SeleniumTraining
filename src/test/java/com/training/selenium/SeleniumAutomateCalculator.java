package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAutomateCalculator {
	static WebDriver driver;
	static class Automatebuttons{

		static void automateNumber1Button() throws InterruptedException {
			Thread.sleep(2000);
			WebElement num1Btn = driver.findElement(By.xpath("//input[@value ='1']"));
			num1Btn.click();
			Thread.sleep(2000);
			}
		static void automateNumber2Button() throws InterruptedException {
			WebElement num2Btn = driver.findElement(By.xpath("//input[@value ='2']"));
			num2Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber3Button() throws InterruptedException {
			WebElement num3Btn = driver.findElement(By.xpath("//input[@value ='3']"));
			num3Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber4Button() throws InterruptedException {
			WebElement num4Btn = driver.findElement(By.xpath("//input[@value ='4']"));
			num4Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber5Button() throws InterruptedException {
			WebElement num5Btn = driver.findElement(By.xpath("//input[@value ='5']"));
			num5Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber6Button() throws InterruptedException {
			WebElement num6Btn = driver.findElement(By.xpath("//input[@value ='6']"));
			num6Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber7Button() throws InterruptedException {
			WebElement num7Btn = driver.findElement(By.xpath("//input[@value ='7']"));
			num7Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber8Button() throws InterruptedException {
			WebElement num8Btn = driver.findElement(By.xpath("//input[@value ='8']"));
			num8Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber9Button() throws InterruptedException {
			WebElement num9Btn = driver.findElement(By.xpath("//input[@value ='9']"));
			num9Btn.click();
			Thread.sleep(2000);
		}
		static void automateNumber0Button() throws InterruptedException {
			WebElement num0Btn = driver.findElement(By.xpath("//input[@value ='0']"));
			num0Btn.click();
			Thread.sleep(2000);
			
				}
		static void suboperationButton() throws InterruptedException {
			WebElement subBtn= driver.findElement(By.xpath("//input[@value ='-']"));
			subBtn.click();
			Thread.sleep(2000);	
		}
		static void sumoperationButton() throws InterruptedException {
			WebElement sumBtn= driver.findElement(By.xpath("//input[@value ='+']"));
			sumBtn.click();
			Thread.sleep(2000);	
		}
		static void multiplyoperationButton() throws InterruptedException {
			WebElement prdBtn= driver.findElement(By.xpath("//input[@value ='x']"));
			prdBtn.click();
			Thread.sleep(2000);	
		}
		static void DivideoperationButton() throws InterruptedException {
			WebElement divBtn= driver.findElement(By.xpath("//input[@value ='/']"));
			divBtn.click();
			Thread.sleep(2000);	
		}
		static void equalsButton() throws InterruptedException {
			WebElement equalsBtn = driver.findElement(By.xpath("//input[@value ='=']"));
			equalsBtn.click();
			Thread.sleep(2000);
			}
		
			
	}
	static void logInToApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
//		 enter the username
		 WebElement username = driver.findElement(By.id("email_field"));
		 username.sendKeys("admin123@gmail.com");
		 Thread.sleep(4000);
//		 enter the password
		 WebElement password = driver.findElement(By.id("password_field"));
		 password.sendKeys("admin123");
		 Thread.sleep(4000);
//		 perform click operation on login button
		 WebElement login = driver.findElement(By.xpath("//button[text() = 'Login to Account']"));
		 login.click();
		 Thread.sleep(7000);
	}
	
	static void calculatorTab() throws InterruptedException {
		WebElement calculator = driver.findElement(By.xpath("//a[contains(text(),'Calculator')]"));
		calculator.click();
		
	}
	static void readResult() {
		WebElement readresult = driver.findElement(By.xpath("//input[@type = 'text']"));
		String calculation = readresult.getAttribute("value");
		System.out.println("Result: " + calculation);
		
//		We locate the input field where the result is displayed using the XPath //input[@type='text'].
//		We retrieve the text value from this input field using the getAttribute("value") method. This will give us the value displayed in the input field.
//		Finally, we print the result in the console.
//		
	}
	public static void main(String[] args) throws InterruptedException {
		logInToApplication();
		calculatorTab();
//		Automatebuttons.automateNumber3Button();
//		Automatebuttons.automateNumber8Button();
		Automatebuttons.automateNumber6Button();
		Automatebuttons.DivideoperationButton();
		Automatebuttons.automateNumber2Button();
		Automatebuttons.equalsButton();
		readResult();
		Thread.sleep(4000);
		driver.quit();
	}
}
