package registrationDesk;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import configuration.ConfigurationSetup;
import pageObject.LoginPage;
import testBase.TestBase;

@Listeners(cutomListeners.ExtentManagerListeners.class)
public class RegisterPatient extends TestBase {
	
	@Test(description="Verify User is able to register New Patient")
	public static void registerNewPatient()
	{		
		LoginPage.login(ConfigurationSetup.userName, ConfigurationSetup.password, "Registration Desk");
				
	}
	
	@Test(description="Verify User is able to Search Patient")
	public static void SearchPatient()
	{
		LoginPage.login(ConfigurationSetup.userName, ConfigurationSetup.password, "Registration Desk");
			
	
	}
	
	
}
