package registrationDesk;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class RegisterPatient extends TestBase {
	
	@Test
	public static void registerNewPatient()
	{
		
		
		login();
		Navigate();
		Create();
		Validate();
		Logout();
		extent.flush();
		
	}
	
	@Test
	public static void registerNewPatient1()
	{
		
		login();
		Navigate();
		Create();
		Validate();
		Logout();
		pNode.fail("Logout");
		extent.flush();
	
	}
	
	public static void login()
	{
	System.out.println();
	pNode.log(Status.PASS,"Enter UserName: ");
	pNode.log(Status.PASS,"Enter Password: ");
	pNode.log(Status.PASS,"Click");
	extent.flush();
	}
	public static void Navigate()
	{
	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");
	extent.flush();
	}
	public static void Create()
	{

	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");
	extent.flush();
	}
	public static void Logout()
	{

	pNode.info("Enter UserName: ");
	pNode.info("Enter Password: ");
	pNode.info("Click");
	extent.flush();
	}
	public static void Validate()
	{

	pNode.log(Status.PASS,"Enter UserName: ");
	enter();
	pNode.log(Status.PASS,"Enter Password: ");
	pNode.log(Status.PASS,"Click");
	extent.flush();
	}
	
	public static void enter()
	{

		pNode.log(Status.PASS,"Entered Successfully");
		extent.flush();
	}

}
