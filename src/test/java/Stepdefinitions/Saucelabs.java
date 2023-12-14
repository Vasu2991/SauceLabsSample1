package Stepdefinitions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import genericFunctions.ExcelData;
//import genericFunctions.PlaywrightFactory;
//import genericFunctions.ReadProperties;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
		// System.out.println(scenario.getName());

	}
	
	@Given("^User launched sauce labs application \"(.*)\"$")
	public void User_launched_sauce_labs_application(int TC) {
		SauceLabsLoginPage = new SauceLabsLoginPage(page);
		try {
			//this.scenario = CommonSteps.scenario;
			data = readData.getCellData(scenario.getName(), TC);
			SauceLabsLoginPage.login(data);
		} catch (Exception e) {
			// TODO: handle exception
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User selected any item and added a item to the cart \"(.*)\"$")
	public void User_selected_any_item_and_added_a_item_to_the_cart(int TC) {
		SauceLabsHomePage = new SauceLabsHomePage(page);
		try {
			//this.scenario = CommonSteps.scenario;
			data = readData.getCellData(scenario.getName(), TC);
			SauceLabsHomePage.addToCart(data);
		} catch (Exception e) {
			// TODO: handle exception
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User goes to the cart page to submit the order \"(.*)\"$")
	public void User_goes_to_the_cart_page_to_submit_the_order(int TC) {
		SauceLabsHomePage = new SauceLabsHomePage(page);
		try {
			//this.scenario = CommonSteps.scenario;
			data = readData.getCellData(scenario.getName(), TC);
			SauceLabsHomePage.clickOnShoppingCartLink(data);
		} catch (Exception e) {
			// TODO: handle exception
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
	
	@Given("^User clicks on chekout and places the order \"(.*)\"$")
	public void User_clicks_on_chekout_and_places_the_order(int TC) {
		SauceLabsCheckoutPage = new SauceLabsCheckoutPage(page);
		try {
			//this.scenario = CommonSteps.scenario;
			data = readData.getCellData(scenario.getName(), TC);
			SauceLabsCheckoutPage.clickOnCheckout(data);
			SauceLabsCheckoutPage.enterAddressAndClickOnContinue(data);
			SauceLabsCheckoutPage.clickOnFinishAndVerifySuccessfulMessage(data);
		} catch (Exception e) {
			// TODO: handle exception
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			Assert.assertTrue(false, sw.toString());
		}
	}
		
	}
