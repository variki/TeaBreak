package testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import configuration.ConfigurationSetup;
import reportManager.ExtentManager;
import utilities.DriverFactory;

public class TestBase {
	protected static ExtentReports extent;
	protected static ExtentTest pNode;
	public static WebDriver driver;
	protected static final Logger log = Logger.getLogger(TestBase.class);

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
	public void beforeTest()
	{
		// Initialize Driver
				DriverFactory instanceDriver = DriverFactory.getInstance();
				driver = instanceDriver.browserSetup(ConfigurationSetup.browser);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get(ConfigurationSetup.base_url);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
