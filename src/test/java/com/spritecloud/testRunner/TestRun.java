package com.spritecloud.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	
		features = {".//Features//Web Automation/Web.feature"},
		glue="com.spritecloud.stepdefs",
		dryRun = false,
		monochrome = true,
		tags = "@Batch",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html","testng:target/cucumber-reports/reports_xml.xml","json:target/cucumber-reports/reports_json.json"}
		)

public class TestRun extends AbstractTestNGCucumberTests{

}
