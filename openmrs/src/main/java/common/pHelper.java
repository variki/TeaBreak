package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import testBase.TestBase;

public class pHelper extends TestBase{
	
	public static void setCurrentTestName(String name)
	{
		currentTestName =  name;
		
	}
	
	public static void highlightElement(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style','border: solid 4px yellow')", element);((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid yellow'", element);
	}
	public static void unhighlightElement(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].removeAttribute('style','border: solid 4px yellow')", element);
	}

}
