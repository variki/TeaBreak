package pageObject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import common.pInteractElement;
import testBase.TestBase;
import utilities.DatabaseQuery;

public class NewCustomerPage extends TestBase {
	private static By cNameTxtBox = By.name("name");
	private static By genderMaleRadiobtn = By.xpath("//input[@value='m']");
	private static By genderfemaleRadiobtn = By.xpath("//input[@value='f']");
	private static By dateOfBirthTxtBox = By.id("dob");
	private static By addressTxtBox = By.name("addr");
	private static By cityTxtBox = By.name("city");
	private static By stateTxtBox = By.name("state");
	private static By pinTxtBox = By.name("pinno");
	private static By telephoneTxtBox = By.name("telephoneno");
	private static By emailidTxtBox = By.name("emailid");
	private static By passwordTxtBox = By.name("password");
	private static By submitBtn = By.name("sub");
	private static By resetBtn = By.name("res");
	private static By successMsgTxt = By.cssSelector("p.heading3");
	private static By customerIdTxt = By.xpath("//table[@id='customer']//tr[4]//td[2]");

	public static void createCustomer(String custName, String gender, String DOB, String Address, String city,
			String state, String pin, String mobNumber, String email, String password) {
		CommonPage.leftNavSelect("New Customer");
		pInteractElement.interactElementByType(cNameTxtBox, custName);
		if (gender.toLowerCase().equals("male")) {
			pInteractElement.interactElementByclick(genderMaleRadiobtn, true);
		} else {
			pInteractElement.interactElementByclick(genderfemaleRadiobtn, true);
		}
		pInteractElement.interactElementByType(dateOfBirthTxtBox, DOB);
		pInteractElement.interactElementByType(addressTxtBox, Address);
		pInteractElement.interactElementByType(cityTxtBox, city);
		pInteractElement.interactElementByType(stateTxtBox, state);
		pInteractElement.interactElementByType(pinTxtBox, pin);
		pInteractElement.interactElementByType(telephoneTxtBox, mobNumber);
		pInteractElement.interactElementByType(emailidTxtBox, email);
		pInteractElement.interactElementByType(passwordTxtBox, password);
		pInteractElement.interactElementByclick(submitBtn, true);
		assertEquals(pInteractElement.getElementText(successMsgTxt), "Customer Registered Successfully!!!");
		DatabaseQuery.insertDataToCustomer(custName, gender, DOB, Address, city, state, pin, mobNumber, email,
				pInteractElement.getElementText(customerIdTxt));

	}

	public void verifycustomerDetails() {

	}

}
