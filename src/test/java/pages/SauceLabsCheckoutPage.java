package pages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;


public class SauceLabsCheckoutPage {
	
	Page page;
	String checkout = "//button[@id='checkout']";
	String firstName = "//input[@id='first-name']";
	String lastName = "//input[@id='last-name']";
	String postalcode = "//input[@id='postal-code']";
	String continuebutton = "//input[@id='continue']";
	String finish = "//button[@id='finish']";
	String successfulMessagevalue = "//div[@id='checkout_complete_container']/h2";
	
 public SauceLabsCheckoutPage(Page page) {
		this.page=page;
		
	}
	
	public void clickOnCheckout(HashMap data) {
		page.locator(checkout).click();
		page.waitForTimeout(2000);
		
	}
	
	public void enterAddressAndClickOnContinue(HashMap data) {
		page.locator(firstName).fill(data.get("firstname").toString());
		page.waitForTimeout(2000);
		page.locator(lastName).fill(data.get("lastname").toString());
		page.waitForTimeout(2000);
		page.locator(postalcode).fill(data.get("zipcode").toString());
		page.waitForTimeout(2000);
		page.locator(continuebutton).click();
		page.waitForTimeout(2000);
		
	}
	
	public void clickOnFinishAndVerifySuccessfulMessage(HashMap data) {
		page.locator(finish).click();
		page.waitForTimeout(2000);
		String successfulMessage = page.locator(successfulMessagevalue).textContent();
		Assert.assertEquals(successfulMessage, "Thank you for your order!");
	}
	
	
}