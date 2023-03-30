package stc.specs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import stc.pages.SubscriptionPage;

public class StcSaudiArabiaTest extends BaseTest{
	private SubscriptionPage subscriptionPage;
	private final String country = "KSA";
	
	
  @BeforeClass()
  public void init() throws Exception {
	  subscriptionPage = new SubscriptionPage(this.driver);
	  subscriptionPage.selectCountry(country);
  }
  
  @Test
  @Description("Assert Plan Type for KSA")
  public void TC01_TestPlanTypeForKSA() throws Exception {
	  assertEquals(subscriptionPage.getPlanType("Lite").toLowerCase(), "lite");
	  assertEquals(subscriptionPage.getPlanType("Classic").toLowerCase(), "classic");
	  assertEquals(subscriptionPage.getPlanType("Premium").toLowerCase(), "premium");
  }
  
  @Test
  @Description("Assert Plan Prices for KSA")
  public void TC02_TestPlanPriceForKSA() throws Exception {
	  assertEquals(subscriptionPage.getPlanPrice("Lite"), "15");
	  assertEquals(subscriptionPage.getPlanPrice("Classic"), "25");
	  assertEquals(subscriptionPage.getPlanPrice("Premium"), "60");
  }
  
  @Test
  @Description("Assert Currency for KSA")
  public void TC03_TestPlanCurrencyForKSA() throws Exception {
	  String expectedCurrency = "SAR";
	  assertTrue(subscriptionPage.getPlanCurrency("Lite").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Classic").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Premium").contains(expectedCurrency));
  }
  
  @AfterMethod()
  public void leave() {
	  subscriptionPage.screenshot();
  }
}
