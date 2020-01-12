package pageObject;

import org.openqa.selenium.By;

import common.pInteractElement;
import configuration.ConfigurationSetup;
import testBase.TestBase;

public class LoginPage extends TestBase {
	
	private static By userName_TB = By.name("uid");
	private static By password_TB = By.name("password");
	private static By sessionLocation_CB = By.id("Registration Desk");
	private static By login_Btn = By.name("btnLogin");
	
	public static void login(String userName,String pwd,String sessionLocation)
	{
		driver.get(ConfigurationSetup.base_url);
		pInteractElement.interactElementByType(userName_TB,userName);
		pInteractElement.interactElementByType(password_TB, pwd);
		//pInteractElement.interactElementByclick(sessionLocation_CB, true);
		pInteractElement.interactElementByclick(login_Btn, true);
		
	}

}
