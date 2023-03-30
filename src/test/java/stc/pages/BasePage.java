package stc.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Attachment;
import stc.config.BrowserConfiguration;
import stc.utils.Log;


public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private BrowserConfiguration webConfig;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.webConfig = new BrowserConfiguration();
		this.wait = new WebDriverWait(driver, Duration.ofMillis(this.webConfig.explicitWait()));
	}
	
	public WebElement findElement(By by) {
		this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
		WebElement el = this.driver.findElement(by);
		this.highlightElement(el);
		return el;
	}
	
	public void highlightElement(WebElement el) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px solid yellow';", el);
	}
	
	public Boolean isElementVisible(By by) {
		Boolean isVisible = false;
		try {
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			isVisible = true;
			Log.debug("Element is visible: " + by.toString());
		}catch(TimeoutException e) {
			// Log exception message here
			Log.debug("Element is not visible: " + by.toString());
		}
		return isVisible;
		
	}
	
	public Boolean isElementClickable(By by) {
		Boolean isClickable = false;
		try {
			this.wait.until(ExpectedConditions.elementToBeClickable(by));
			isClickable = true;Log.debug("Element is not clickable: " + by.toString());
			Log.debug("Element is clickable: " + by.toString());
		}catch(TimeoutException e) {
			// Log exception message here
			Log.debug("Element is not clickable: " + by.toString());
		}
		return isClickable;
	}
	
	public WebElement moveToElement(By by) {
		WebElement el = this.findElement(by);
		Actions actions = new Actions(this.driver);
		actions
		.moveToElement(el)
		.build()
		.perform();
		return el;
	}
	
	public WebElement clickElement(By by) throws Exception {
		WebElement el = this.findElement(by);
		try {
			Log.info("Click Element Natively: " + by.toString());
			this.wait.until(ExpectedConditions.elementToBeClickable(el));
			Actions actions = new Actions(this.driver);
			actions
			.moveToElement(el)
			.click()
			.build()
			.perform();
	
		}catch(ElementClickInterceptedException e) {
			Log.debug("Clicking Element using a click action failed. Trying with javascript");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", el);
			js.executeScript("arguments[0].click();", el);
		}catch(Exception e) {
			Log.error(e.getMessage());
			throw new Exception("Could not click element with error: " + e.getMessage());
		}
		return el;

	}
	
	public WebElement scrollToMe(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement el = this.findElement(by);
		js.executeScript("arguments[0].scrollIntoView(true);", el);
		return el;
	}
	
	public Boolean elementHasClass(WebElement el, String clsName) {
		String classList = el.getAttribute("class");
		for(String cls: classList.split(" ")) {
			if(cls.equals(clsName)) return true;
		}
		return false;
	}
	
	@Attachment(value = "Page Screenshot", type="image/png")
	public byte[] screenshot() {
		Log.info("Capturing page screenshot");
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}
}
