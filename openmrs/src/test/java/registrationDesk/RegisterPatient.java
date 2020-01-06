package registrationDesk;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import testBase.TestBase;

@Listeners(cutomListeners.ExtentManagerListeners.class)
public class RegisterPatient extends TestBase {
	
	@Test(description="Verify User is able to register New Patient")
	public static void registerNewPatient()
	{
		
		
		login();
		Navigate();
		Create();
		Validate();
		Logout();
		
		
	}
	
	@Test(description="Verify User is able to Search Patient")
	public static void SearchPatient()
	{
		
		login();
		Navigate();
		Create();
		Validate();
		Logout();
		
	
	}
	
	public static void login()
	{
	System.out.println();
	pNode.log(Status.PASS,"Enter UserName: ");
	pNode.log(Status.PASS,"Enter Password: ");
	pNode.log(Status.PASS,"Click");
	
	}
	public static void Navigate()
	{
	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");

	}
	public static void Create()
	{

	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");

	}
	public static void Logout()
	{

	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");
	
	}
	public static void Validate()
	{

	pNode.log(Status.PASS,"Enter UserName: ");
	enter();
	pNode.log(Status.PASS,"Enter Password: ");
	pNode.log(Status.PASS,"Click");

	}
	
	public static void enter()
	{

		pNode.log(Status.PASS,"Entered Successfully");
		
	}

}
