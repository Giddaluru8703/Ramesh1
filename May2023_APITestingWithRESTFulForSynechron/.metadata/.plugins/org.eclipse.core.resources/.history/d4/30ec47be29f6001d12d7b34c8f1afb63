package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java",
								glue="stepDefinations",
								dryRun=false,
								plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
								)
public class TestRunner extends AbstractTestNGCucumberTests{

}
