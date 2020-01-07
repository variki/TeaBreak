package reportManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import configuration.ConfigurationSetup;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getIntance() {
		if (extent == null) {
			extent = createInstance();
		}

		return extent;
	}

	private static ExtentReports createInstance() {
		//String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm").format(new Date());
		String fileName = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Local");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Expected Browser", ConfigurationSetup.browser);
		extent.setSystemInfo("Expected Environment", ConfigurationSetup.env);
		return extent;

	}

}
