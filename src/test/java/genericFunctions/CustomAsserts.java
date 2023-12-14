package genericFunctions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.assertions.*;
public class CustomAsserts{
	
	public static void containsString(String locatorText, String text) {
		if (locatorText.contains(text)) {
			ExtentCucumberAdapter.addTestStepLog("user clicked on Sign in button");
			
		} else {
			ExtentCucumberAdapter.addTestStepLog("user clicked on Sign in button");
		}
	}
}