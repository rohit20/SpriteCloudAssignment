package com.spritecloud.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicIdPage {
	
WebDriver driver;
	
	public DynamicIdPage(WebDriver remotedriver) {
		
		driver= remotedriver;
		PageFactory.initElements(driver, this);				
	}
	
	
	@FindBy(xpath= "//h4[text()='Playground']//following-sibling::button")
	WebElement dynamicButton;
	
	public static void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	public boolean verifydynamicButton(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return dynamicButton.isDisplayed();
	}
	
	public void clickDynamicButton() {
		highLighterMethod(driver, dynamicButton);
		dynamicButton.click();
	}

}
