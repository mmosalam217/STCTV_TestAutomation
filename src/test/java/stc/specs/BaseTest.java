package stc.specs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import stc.config.BrowserConfiguration;
import stc.config.BrowserFactory;

public class BaseTest {
	protected WebDriver driver;
	
	protected BrowserConfiguration webConfig;
	
	public BaseTest() {
		this.webConfig = new BrowserConfiguration();
	}
	
	@BeforeTest()
	public void setup() {
		driver = BrowserFactory.getDriver(this.webConfig.browser());
		driver.get(this.webConfig.baseUrl());
		if(this.webConfig.maximized()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(this.webConfig.implicitWait()));
	}
	
	@AfterTest()
	public void teardown() {
		if(driver != null) driver.quit();
	}
}
