package com.spritecloud.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientSideDelayPage {
	WebDriver driver;

	public ClientSideDelayPage(WebDriver remotedriver) {

		driver= remotedriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//button[text()='Button Triggering Client Side Logic']")
	WebElement buttonTriggeringText;

	public static void highLighterMethod(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	public void clickTriggerButton() {
		highLighterMethod(driver, buttonTriggeringText);
		buttonTriggeringText.click();
	}

	public void waitForLabel() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement label = 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='bg-success']")));
		highLighterMethod(driver, label);
	}

}
