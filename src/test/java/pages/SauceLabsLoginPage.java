package pages;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;



public class SauceLabsLoginPage {
	
	Page page;
	String Username = "//input[@id='user-name']";
	String password = "//input[@id='password']";
	String login = "//input[@id='login-button']";
	String products = "//span[text()='Products']";
	
	public SauceLabsLoginPage(Page page) {
		this.page=page;
		
	}
	
	public void login(HashMap data) {
		page.navigate((String) data.get("url"));
		page.locator(Username).fill(data.get("username").toString());
		page.locator(password).fill(data.get("password").toString());
		page.waitForTimeout(3000);
		page.locator(login).click();
		page.waitForTimeout(6000);
		String text = page.locator(products).textContent();
		Assert.assertEquals(text, "Products");
		
	}
}