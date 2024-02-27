package stc.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserFactory {

	
	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		switch(browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			// Fix for chrome driver remote origin issue
			// See also: https://stackoverflow.com/questions/75678572/java-io-ioexception-invalid-status-code-403-text-forbidden
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			ChromeOptions opts = new ChromeOptions();
			// Fix for chrome driver remote origin issue
			// See also: https://stackoverflow.com/questions/75678572/java-io-ioexception-invalid-status-code-403-text-forbidden
			opts.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(opts);
			break;
		}
		return driver;
	}
}
