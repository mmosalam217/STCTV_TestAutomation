package stc.specs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import stc.pages.SubscriptionPage;

public class StcKuwaitTest extends BaseTest{
	private SubscriptionPage subscriptionPage;
	private final String country = "Kuwait";
	
	
  @BeforeClass()
  public void init() throws Exception {
	  subscriptionPage = new SubscriptionPage(this.driver);
	  subscriptionPage.selectCountry(country);
  }
  
  @Test
  @Description("Assert Plan Type for Kuwait")
  public void TC01_TestPlanTypeForKuwait() throws Exception {
	  assertEquals(subscriptionPage.getPlanType("Lite").toLowerCase(), "lite");
	  assertEquals(subscriptionPage.getPlanType("Classic").toLowerCase(), "classic");
	  assertEquals(subscriptionPage.getPlanType("Premium").toLowerCase(), "premium");
  }
  
  @Test
  @Description("Assert Plan Prices for Kuwait")
  public void TC02_TestPlanPriceForKuwait() throws Exception {
	  assertEquals(subscriptionPage.getPlanPrice("Lite"), "1.2");
	  assertEquals(subscriptionPage.getPlanPrice("Classic"), "2.5");
	  assertEquals(subscriptionPage.getPlanPrice("Premium"), "4.8");
  }
  
  @Test
  @Description("Assert Currency for Kuwait")
  public void TC03_TestPlanCurrencyForKuwait() throws Exception {
	  String expectedCurrency = "KWD";
	  assertTrue(subscriptionPage.getPlanCurrency("Lite").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Classic").contains(expectedCurrency));
	  assertTrue(subscriptionPage.getPlanCurrency("Premium").contains(expectedCurrency));
  }
  
  @AfterMethod()
  public void leave() {
	  subscriptionPage.screenshot();
  }
}
