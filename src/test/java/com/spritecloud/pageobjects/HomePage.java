package com.spritecloud.pageobjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver remotedriver) {
		
		driver= remotedriver;
		PageFactory.initElements(driver, this);				
	}
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement uiTap;
	
	@FindBy(xpath= "//a[text()='Dynamic ID']")
	WebElement	dynamicID;
	
	@FindBy(xpath= "//a[text()='Dynamic Table']")
	WebElement dynamicTable;
	
	@FindBy(xpath= "//a[text()='Client Side Delay']")
	WebElement clientSideDelay;
	
	
	public static void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	public void clickDynamicTable() {
		highLighterMethod(driver,dynamicTable);
		dynamicTable.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void clickDynamicId() {
		highLighterMethod(driver,dynamicID);
		dynamicID.click();
	}
	
	public void clickClientDelay() {
		highLighterMethod(driver,clientSideDelay);
		clientSideDelay.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
}
