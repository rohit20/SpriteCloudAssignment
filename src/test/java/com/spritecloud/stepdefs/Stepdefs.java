package com.spritecloud.stepdefs;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.spritecloud.pageobjects.ClientSideDelayPage;
import com.spritecloud.pageobjects.DynamicIdPage;
import com.spritecloud.pageobjects.DynamicTablePage;
import com.spritecloud.pageobjects.HomePage;
import com.spritecloud.utils.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefs extends BaseTest{
	 	
	@Before
	public void setup() {
		readConfig = new ReadConfig();		
		//initialise logger
		log = LogManager.getLogger("Stepdefs");
		String browser = readConfig.getBrowser();

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			homepage = new HomePage(driver);
			dynamicidpage= new DynamicIdPage(driver);
			dyanmictablepage = new DynamicTablePage(driver);
			clientsidedelaypage = new ClientSideDelayPage(driver);
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		log.fatal("Setup executed...");
	}
	
	@Given("User is navigated to application type {string}")
	public void user_is_navigated_to(String automationType){
		try {
			if(automationType.equals("web")) {
				log.info("The Type of Automation is web");
				String webUrl = readConfig.getWebUrl();
				driver.get(webUrl);
				log.info("Navigated to web url");
			}
			else if(automationType.equals("api")) {
				log.info("The Type of Automation is api");
				String apiUrl = readConfig.getApiUrl();
				driver.get(apiUrl);
				log.info("Navigated to api url");
			}
			else
			{
				log.info("Please check the parameter properly");
			}
		}catch(Exception e)
		{
			log.error("check the parameter");
		}

	}

	@Then("Title of Page should be {string}")
	public void title_of_page_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle))
		{
			log.info("Test passed: Login feature :Page title matched.");
			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			log.warn("Test Failed: Login feature- page title not matched.");
		}
	}

	@And ("I navigated to Dynamic ID Page")
	public void i_navigated_to_dynamic_id_page() {
		homepage.clickDynamicId();
		log.info("Navigated to dynamic id page");
	}
	
	@And ("I navigated to Dynamic Table Page")
	public void i_navigated_to_client_delay_page() {
		homepage.clickDynamicTable();
		log.info("Navigated to dynamic table page");
	}
	
	@And ("I navigated to Client Side Delay Page")
	public void i_navigated_to_dynamic_table_page() {
		homepage.clickClientDelay();
		log.info("Navigated to Client Side Delay page");
	}
	
	@Then ("I verify and click on element which has dynamic ID")
	public void i_verified_and_click_on_dynamic_id() {
		if(dynamicidpage.verifydynamicButton())
		{
			Assert.assertTrue(true);
			log.info("Dynamic ID element is present");
			dynamicidpage.clickDynamicButton();		
		}
		else
		{
			log.info("Dynamic Id is not proper");
			Assert.assertFalse(false);;
		}
	}
	
	@And("I verify webtable for chrome option")
	public void getCpuValueFromTable() throws InterruptedException {
		String tableOutput = dyanmictablepage.getChromeValueFromTable();
		log.info("Value of chrome Cpu is" + " " + tableOutput);
		String highlightedChrome= dyanmictablepage.getChromeValueFromTable();
		log.info("Value of chrome Cpu highlited is" + " " + highlightedChrome);
		if(tableOutput.equals(highlightedChrome))
		{
			log.info("Value of webtable is matched");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Value of webtable is not matched");
			Assert.assertFalse(false);
		}
	}
	
	@And("I click on trigger button and wait till data appears")
	public void click_trigger_wait() {	
		clientsidedelaypage.clickTriggerButton();
		log.info("Clicked on Triggering button");
		log.info("Waiting for element to trigger");
		clientsidedelaypage.waitForLabel();
		log.info("Data gets populayed");
		
	}
	
	@Then("User close the browser")
	public void user_close_the_browser() {
	   driver.quit();
	    
	}
	@After
	public void teardown(Scenario sc)
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Assignment\\SpriteCloudCucumber\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
