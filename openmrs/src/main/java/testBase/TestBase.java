package testBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

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
	
	@BeforeTest
	public void beforeTest()
	{
		// Initialize Driver
				DriverFactory instanceDriver = DriverFactory.getInstance();
				driver = instanceDriver.browserSetup(ConfigurationSetup.browser);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite() {

	}

}
