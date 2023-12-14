package pages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;


public class SauceLabsHomePage {
	
	Page page;
	String addToCartSauceLabsBackpack = "//button[@id='add-to-cart-sauce-labs-backpack']";
	String shoppingCartLink = "//a[@class='shopping_cart_link']";
 public SauceLabsHomePage(Page page) {
		this.page=page;
		
	}
	
	public void addToCart(HashMap data) {
		page.waitForTimeout(3000);
		page.locator(addToCartSauceLabsBackpack).click();
		page.waitForTimeout(2000);
		
	}
	
	public void clickOnShoppingCartLink(HashMap data) {
	
		page.locator(shoppingCartLink).click();
		page.waitForTimeout(2000);
		
	}
}