package stc.config;

import java.util.Properties;

import stc.utils.Log;



public class BrowserConfiguration extends ConfigurationHandler{
	
	private Properties props;
	
	public BrowserConfiguration() {
		this.props = this.load("browser.properties");
	}
	
	public String browser() {
		String browser = null;
		try{
			browser = this.props.getProperty("browser");
		}catch(Exception e) {
			Log.info("No browser specificed in config. Fall back to standard browser...");
			browser = "Chrome";
		}
		return browser;
	}

	public String baseUrl() {
		return this.props.getProperty("baseUrl");
	}

	public long implicitWait() {
		long wait = 0;
		try {
			wait = Long.valueOf(this.props.getProperty("implicitWait"));
		}catch(Exception e) {
			Log.info("No implicit wait specificed in config. Fall back to standard wait...");
			wait = 10000;
		}
		return wait;
	}

	public long explicitWait() {
		long wait = 0;
		try {
			wait = Long.valueOf(this.props.getProperty("explicitWait"));
		}catch(Exception e) {
			Log.info("No exciplict wait specificed in config. Fall back to standard wait...");
			wait = 10000;
		}
		return wait;

	}
	
	public Boolean headless() {
		try {
			return Boolean.valueOf(this.props.getProperty("headless"));
		}catch(Exception e) {
			Log.info("No launch mode specificed in config. Use headed mode instead...");
			return false;
		}
	}
	
	public Boolean maximized() {
		try {
			return Boolean.valueOf(this.props.getProperty("maximized"));
		}catch(Exception e) {
			Log.info("No window settings specificed in config. Fall back to starting maximized...");
			return true;
		}
	}

}
