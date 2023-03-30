package stc.specs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import stc.pages.SubscriptionPage;

public class StcBahrainTest extends BaseTest{
	private SubscriptionPage subscriptionPage;
	private final String country = "Bahrain";
	
	
  @BeforeClass()
  public void init() throws Exception {
	  subscriptionPage = new SubscriptionPage(this.driver);
	  subscriptionPage.selectCountry(country);
  }
  
  @Test
  @Description("Assert Plan Type for Bahrain")
  public void TC01_TestPlanTypeForBahrain() throws Exception {
	  assertEquals(subscriptionPage.getPlanType("Lite").toLowerCase(), "lite");
	  assertEquals(subscriptionPage.getPlanType("Classic").toLowerCase(), "classic");
	  assertEquals(subscriptionPage.getPlanType("Premium").toLowerCase(), "premium");
  }
  
  @Test
  @Description("Assert Plan Prices for Bahrain")
  public void TC02_TestPlanPriceForBahrain() throws Exception {
	  assertEquals(subscriptionPage.getPlanPrice("Lite"), "2");
	  assertEquals(subscriptionPage.getPlanPrice("Classic"), "3");
	  assertEquals(subscriptionPage.getPlanPrice("Premium"), "6");
  }
  
  @Test
  @Description("Assert Currency for Bahrain")
  public void TC03_TestPlanCurrencyForBahrain() throws Exception {
	  String expectedCurrency = "BHD";
	  assertTrue(subscriptionPage.getPlanCurrency("Lite").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Classic").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Premium").contains(expectedCurrency));
  }
  
  @AfterMethod()
  public void leave() {
	  subscriptionPage.screenshot();
  }
}
