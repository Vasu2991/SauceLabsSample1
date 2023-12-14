package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true,
features = "src/test/resources/features/StudentTestCases1.feature",
glue = {"Stepdefinitions", "Hooks"}, 
tags = "@Batch1,@Batch2",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class StudentTestRunner1 extends AbstractTestNGCucumberTests{
	
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
	
}
