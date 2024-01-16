package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true,
features = "src/test/resources/features/SauceLabs.feature",
glue = {"Stepdefinitions"}, 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class SauceLabsApp extends AbstractTestNGCucumberTests{
		
}
