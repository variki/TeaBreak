package customers;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import configuration.ConfigurationSetup;
import pageObject.LoginPage;
import pageObject.NewCustomerPage;
import testBase.TestBase;
import utilities.DataParameter;

@Listeners(cutomListeners.ExtentManagerListeners.class)
public class Customer extends TestBase {
	/**
	 * This test case is used to create new customer
	 */

	@Test(description = "Verify User is able to create new customer", dataProvider = "getData", dataProviderClass = DataParameter.class)
	public static void newCustomer(Hashtable<String,String> data) {
		
		//pNode.info(MarkupHelper.createCodeBlock(data);
		LoginPage.login(ConfigurationSetup.userName, ConfigurationSetup.password);
		NewCustomerPage.createCustomer(data.get("Customer_Name"), data.get("Gender"), data.get("Date_Of_Birth"), data.get("Address"), data.get("City"), data.get("State"), data.get("Pin"), data.get("Mobile_Number"), data.get("E-Mail"), data.get("Password"));
		
	}
	

}
