package com.training.testcaseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

public class TestCase7 extends BaseTest{
	static String parentwindow;
	static Actions action;
	public static void myProfile() {
		parentwindow = driver.getWindowHandle();
		
		WebElement myprofilebtn = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myprofilebtn.click();
	}
	
	public static void editButtonNextToContact() {
		WebElement edit = driver.findElement(By.xpath("//a[@class=\"contactInfoLaunch editLink\"]"));
		edit.click();
		
	}
	
	public static void aboutInEditBtnNextToContact() {
//		locating frame
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
//		about tab
		driver.findElement(By.id("aboutTab")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@class = 'lastName zen-inputFull zen-input']"));
		lastname.clear();
		lastname.sendKeys("singh");
		WebElement saveallbtn = driver.findElement(By.xpath("//input[@class ='zen-btn zen-primaryBtn zen-pas']"));
		saveallbtn.click();	
	}
	
		public static void postOnHomePage() {
		WebElement postlink = driver.findElement(By.xpath("//a[@class='publisherattach publisherattachTextPost withArrowAttached']"));
		postlink.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement textarea = driver.findElement(By.xpath("//body[contains(text(),'Share an update, @mention someone...')]"));

		textarea.sendKeys("We're continuously striving to improve our services."
				+ " Share your feedback with us by completing a quick survey. Your input is valuable in helping us enhance your experience!");
		driver.switchTo().parentFrame();
		WebElement share = driver.findElement(By.className("bottomBarRight"));
//		System.out.println(share.isDisplayed());
//		System.out.println(share.isEnabled());
			share.click();
	
	}
	
	public static void fileLinkOnHomePage() {
		
		WebElement filelink = driver.findElement(By.xpath("//a[@title ='File']"));
//		System.out.println(filelink.isDisplayed());
		filelink.click();
		
		WebElement uploadfilefromcompbtn = driver.findElement(By.xpath("//a[@title ='Upload a file from your computer']"));
		uploadfilefromcompbtn.click();
//		chooseFileBtn
		driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys("C:\\Users\\teena\\OneDrive\\feb2024\\java\\codingfilestoreadwrite\\test.txt");

//		shareBtn
		 driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
	}
	
	public static void addPhoto() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,10);
//		profileImage
		action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='photoSection']"))).build().perform();

//		addProfilephoto
		driver.findElement(By.xpath("//a[contains(text(),'Add Photo')]")).click();
//		locating frame
		driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
//		choosePhoto
		WebElement choosePhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']")));
		choosePhoto.sendKeys("C:\\Users\\teena\\Downloads\\image1.jpg");
//		save button
		 WebElement savebtn = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		 savebtn.click();
		 
		 WebElement savebtn1 = driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
		 savebtn1.click();
		 
//		 validation
		 WebElement checkphotoisUploaded = driver.findElement(By.xpath("//div[@id='photoSection']"));
		 if(checkphotoisUploaded.isDisplayed()) {
			 System.out.println("TestCase7 is passed");
		 }
		 
	}
	
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		logInToApplication();
		clickOnUserMenu();
		myProfile();
		editButtonNextToContact();
		aboutInEditBtnNextToContact();
		driver.switchTo().defaultContent();
		postOnHomePage();
		fileLinkOnHomePage();
		addPhoto();
		Thread.sleep(4000);
		driver.close();
	}

}
