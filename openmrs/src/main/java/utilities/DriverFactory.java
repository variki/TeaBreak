package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static DriverFactory intanceDriver = null;
	private WebDriver driver;
	
	private DriverFactory()
	{
		
	}
	
	public WebDriver browserSetup(String ExpBrowser)
	{
		if(ExpBrowser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				
		}else if(ExpBrowser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(ExpBrowser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
		
	public static DriverFactory getInstance()
	
	{
		if(intanceDriver == null)
		{
			intanceDriver = new DriverFactory();
		}
		
		return intanceDriver;
		
	}

}
