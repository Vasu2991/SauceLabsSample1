package pages;

import java.util.HashMap;
import org.testng.Assert;
import com.microsoft.playwright.Page;

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
	}
	
	public void enterAddressAndClickOnContinue(HashMap data) {
		page.locator(firstName).fill(data.get("firstname").toString());
		page.locator(lastName).fill(data.get("lastname").toString());
		page.locator(postalcode).fill(data.get("zipcode").toString());
		page.locator(continuebutton).click();
		
	}
	
	public void clickOnFinishAndVerifySuccessfulMessage(HashMap data) {
		page.locator(finish).click();
		String successfulMessage = page.locator(successfulMessagevalue).textContent();
		Assert.assertEquals(successfulMessage, "Thank you for your order!");
	}
	
	
}