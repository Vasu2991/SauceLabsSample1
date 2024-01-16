package pages;

import java.util.HashMap;
import com.microsoft.playwright.Page;

public class SauceLabsHomePage {
	
	Page page;
	String addToCartSauceLabsBackpack = "//button[@id='add-to-cart-sauce-labs-backpack']";
	String shoppingCartLink = "//a[@class='shopping_cart_link']";
 public SauceLabsHomePage(Page page) {
		this.page=page;
		
	}
	
	public void addToCart(HashMap data) {
		page.locator(addToCartSauceLabsBackpack).click();
		
	}
	
	public void clickOnShoppingCartLink(HashMap data) {	
		page.locator(shoppingCartLink).click();
				
	}
}