package com.spritecloud.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.spritecloud.pageobjects.ClientSideDelayPage;
import com.spritecloud.pageobjects.DynamicIdPage;
import com.spritecloud.pageobjects.DynamicTablePage;
import com.spritecloud.pageobjects.HomePage;
import com.spritecloud.utils.ReadConfig;

import java.util.Properties;

import org.apache.logging.log4j.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

//This is the parent class and base class
public class BaseTest {
	
	public static WebDriver driver;
	public HomePage homepage;
	public DynamicIdPage dynamicidpage;
	public  DynamicTablePage dyanmictablepage;
	public ClientSideDelayPage clientsidedelaypage;
	public static Logger log;
	public ReadConfig readConfig;
	
}
