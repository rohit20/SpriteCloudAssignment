package com.spritecloud.pageobjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicTablePage {
	WebDriver driver;
	int columncpu;
	String cpuValue;

	public DynamicTablePage(WebDriver remotedriver) {

		driver= remotedriver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy(xpath = "(//div[@role='rowgroup'])[1]//div//span)")
	WebElement columnHeader;
	
	@FindBy(xpath = "//p[@class='bg-warning']")
	WebElement chromeHighlitedValue;
	
	
	public String getChromeValueFromTable() {
		try {
		List<WebElement> columnHeader = driver.findElements(By.xpath("//span[@role='columnheader']"));
		List<WebElement> chromerow = driver.findElements(By.xpath("//span[text()='Chrome']//following-sibling::span"));
		
		for(int column = 0; column<columnHeader.size();column++)
		{
			String columnText = columnHeader.get(column).getText();
			if(columnText.equals("CPU")) {
				columncpu = column;
				break;
			}
		}
		WebElement value = driver.findElement(By.xpath("//span[text()='Chrome']//following-sibling::span["+columncpu+"]"));
		cpuValue = value.getText();
		}catch(Exception e)
		{
			Assert.fail();
		}		
		return cpuValue;
	}
	
	public String highLightedChromeValue()
	{
		String output = chromeHighlitedValue.getText();
		output.split(": ");
		return output;
	}
}