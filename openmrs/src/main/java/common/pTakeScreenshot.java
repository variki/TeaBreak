package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

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
	
	public static String takeScreenshotAsBase64()
	{
		TakesScreenshot screen = ((TakesScreenshot) driver);
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
		fileInputStreamReader = new FileInputStream(sourceFile);
		byte[] bytes = new byte[(int)sourceFile.length()];
		fileInputStreamReader.read(bytes);
		encodedBase64 = new String(Base64.getEncoder().encodeToString((bytes)));
		 } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
	     return "data:image/png;base64,"+encodedBase64 ;
			
	}
	public static String ptakeScreenshotAsBase64()
	{
		TakesScreenshot screen = ((TakesScreenshot) driver);
		String encodedBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return "data:image/png;base64,"+encodedBase64;
	}

}
