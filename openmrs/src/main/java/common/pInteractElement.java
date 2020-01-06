package common;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class pInteractElement extends TestBase {

	public static void interactElementBy(By by,String value)
	{
		log.info("Interacting the Element with data : " + value);
		pNode.log(Status.INFO,"Entering the data : " + value);
		driver.findElement(by).sendKeys(value);
		
	}
	
	public static void interactElementBy(By by,boolean b)
	{
		log.info("Interacting the Element");
		pNode.log(Status.INFO,"Interacting the Element");
		driver.findElement(by).click();
		
	}
	
	public static void interactElementBySelect(By by, String value)
	{
		
	}

}
