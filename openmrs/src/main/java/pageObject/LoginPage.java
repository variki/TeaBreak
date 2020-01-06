package pageObject;

import org.openqa.selenium.By;

import common.pInteractElement;
import testBase.TestBase;

public class LoginPage extends TestBase {
	
	private static By userName_TB = By.id("username");
	private static By password_TB = By.id("password");
	private static By sessionLocation_CB = By.id("Registration Desk");
	private static By login_Btn = By.id("loginButton");
	
	public static void login(String userName,String pwd,String sessionLocation)
	{
		pInteractElement.interactElementBy(userName_TB,userName);
		pInteractElement.interactElementBy(password_TB, pwd);
		pInteractElement.interactElementBy(sessionLocation_CB, true);
		pInteractElement.interactElementBy(login_Btn, true);
		
	}

}
