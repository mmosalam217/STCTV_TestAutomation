package stc.definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stc.config.BrowserConfiguration;
import stc.config.BrowserFactory;
import stc.pages.SubscriptionPage;

public class PlanTypeStepDefinition {
	protected WebDriver driver;
	protected BrowserConfiguration webConfig;
	private SubscriptionPage subscriptionPage;

	public PlanTypeStepDefinition() {
		this.webConfig = new BrowserConfiguration();
	}
	
	@Before
	public void setup() {
		driver = BrowserFactory.getDriver(this.webConfig.browser());
		if(this.webConfig.maximized()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(this.webConfig.implicitWait()));
	}
	
	@Given("User navigates to the subscriptions page")
	public void navigateToSubscriptionsPage() {
		driver.get(this.webConfig.baseUrl());
		this.subscriptionPage = new SubscriptionPage(this.driver);
	}
	
	@When("User selects the country {string}")
	public void selectCountry(String country) throws Exception {
		this.subscriptionPage.selectCountry(country);
	}
	
	@Then("The plan type {string} should exist")
	public void checkPlanExistsInMarket(String plan) {
		String actual = this.subscriptionPage.getPlanType(plan);
		assertEquals(actual.toLowerCase(), plan.toLowerCase());
	}
	
	@Then("The price for plan {string} should be {string}")
	public void checkPlanPriceForMarket(String plan, String price) {
		String actual = this.subscriptionPage.getPlanPrice(plan);
		assertEquals(actual, price);
	}
	
	@Then("The currency for plan {string} should be {string}")
	public void checkPlanCurrencyForMarket(String plan, String currency) {
		String actual = this.subscriptionPage.getPlanCurrency(plan);
		assertTrue(actual.contains(currency));
	}
	
	@After
	public void teardown() {
		if(driver != null) driver.quit();
	}
	 
}
