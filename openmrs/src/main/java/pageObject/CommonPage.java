package pageObject;

import org.openqa.selenium.By;

import common.pInteractElement;

public class CommonPage {
	
	
	public static void leftNavSelect(String parm)
	{
		pInteractElement.interactElementByclick(By.xpath("//a[contains(text(),'"+parm+"')]"), true);
	}

}
