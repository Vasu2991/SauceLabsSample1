package Stepdefinitions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import org.testng.Assert;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import genericFunctions.ExcelData;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pages.SauceLabsLoginPage;
import pages.SauceLabsHomePage;
import pages.SauceLabsCheckoutPage;

public class Saucelabs {
	Playwright playwright = Playwright.create();
	Browser browser =  playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	BrowserContext browserContext=browser.newContext();
	Page page= browserContext.newPage();
	HashMap<String, String> data;
	ExcelData readData = new ExcelData();
	Scenario scenario;
	SauceLabsLoginPage SauceLabsLoginPage;
	SauceLabsHomePage SauceLabsHomePage;
	SauceLabsCheckoutPage SauceLabsCheckoutPage;
	
	@Before(order = 1)
	public void before(Scenario scenario) {
		this.scenario = scenario;
		page.setDefaultTimeout(15000);
	}
	
	@Given("^User launched sauce labs application$")
	public void User_launched_sauce_labs_application() {
		SauceLabsLoginPage = new SauceLabsLoginPage(page);
		try {		
			data = readData.getCellData(scenario.getName());
			SauceLabsLoginPage.login(data);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User selected any item and added a item to the cart$")
	public void User_selected_any_item_and_added_a_item_to_the_cart() {
		SauceLabsHomePage = new SauceLabsHomePage(page);
		try {
			data = readData.getCellData(scenario.getName());
			SauceLabsHomePage.addToCart(data);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User goes to the cart page to submit the order$")
	public void User_goes_to_the_cart_page_to_submit_the_order() {
		SauceLabsHomePage = new SauceLabsHomePage(page);
		try {
			data = readData.getCellData(scenario.getName());
			SauceLabsHomePage.clickOnShoppingCartLink(data);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User clicks on chekout and places the order$")
	public void User_clicks_on_chekout_and_places_the_order() {
		SauceLabsCheckoutPage = new SauceLabsCheckoutPage(page);
		try {
			data = readData.getCellData(scenario.getName());
			SauceLabsCheckoutPage.clickOnCheckout(data);
			SauceLabsCheckoutPage.enterAddressAndClickOnContinue(data);
			SauceLabsCheckoutPage.clickOnFinishAndVerifySuccessfulMessage(data);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
		
	}
