package testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import configuration.ConfigurationSetup;
import cutomListeners.WebEventListener;
import reportManager.ExtentManager;
import utilities.DriverFactory;

public class TestBase {
	protected static ExtentReports extent;
	protected static ExtentTest pNode;
	private static WebDriver idriver;
	public static EventFiringWebDriver driver;
	protected static final Logger log = Logger.getLogger(TestBase.class);
	protected static WebDriverWait wait;
	private static WebEventListener e;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		// Initialize Configuration
		ConfigurationSetup.init();

		log.info("Host Name : Local Driven");
		log.info("Operating System : " + System.getProperty("os.name").toUpperCase());
		log.info("Browser :" + ConfigurationSetup.browser.toUpperCase());

		// Initialize Extent Report
		extent = ExtentManager.getIntance();

	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod()
	{
		// Initialize Driver
				DriverFactory instanceDriver = DriverFactory.getInstance();
				idriver = instanceDriver.browserSetup(ConfigurationSetup.browser);
				wait = new WebDriverWait(idriver, 60);
				driver = new EventFiringWebDriver(idriver);
				e = new WebEventListener();
				driver.register(e);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}

}
