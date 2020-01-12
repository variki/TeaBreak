package common;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class pInteractElement extends TestBase {

	public static void interactElementByType(By by,String value)
	{
		
		driver.findElement(by).sendKeys(value);
		
	}
	
	public static void interactElementByclick(By by,boolean b)
	{
		
		driver.findElement(by).click();
		
	}
	
	public static void interactElementBySelect(By by, String value)
	{
		
	}

	public static String getElementText(By successMsgTxt) {
		return driver.findElement(successMsgTxt).getText();
		
	}

}
