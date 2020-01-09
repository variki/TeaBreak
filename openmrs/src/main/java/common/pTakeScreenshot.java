package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class pTakeScreenshot extends TestBase {

	public static String takeScreenshotAsElement(WebElement element) {
		String screenPath = "./target/screenshot/" + currentTestName + "/" + count.incrementAndGet() + ".png";
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenPath = System.getProperty("user.dir") + screenPath;
		return screenPath;
	}

	public static String takesScreenshotAsFull() {
		String screenPath = "./target/screenshot/" + currentTestName + "/" + count.incrementAndGet() + ".png";
		TakesScreenshot screen = ((TakesScreenshot) driver);
		File srcFile = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenPath = System.getProperty("user.dir") + screenPath;
		return screenPath;
	}

}
