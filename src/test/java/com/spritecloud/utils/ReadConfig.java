package com.spritecloud.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path = "config.properties";
	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();
			//to open config .properties file in input mode and load the file
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Reading browser name from config
	public String getBrowser()
	{
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file.");
	}
		//Reading Web Url
	public String getWebUrl()
	{
		String value = properties.getProperty("webUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("webUrl not specified in config file.");
	}
	//Reading Api Url
	public String getApiUrl()
	{
		String value = properties.getProperty("apiUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("apiUrl not specified in config file.");
	}

}
