package configuration;

import utilities.Constants;
import utilities.ExcelUtilities;

public class ConfigurationSetup extends Constants {
	public static String browser,userName,password,env,base_url;
	private static ExcelUtilities excel;

public ConfigurationSetup()
{
	excel = new ExcelUtilities(CONFIG_FILE);
}
public static void init()
{
	ConfigurationSetup config = new ConfigurationSetup();
	// getting Expected Browser Name
	browser = excel.getCelldata(LOCAL_SHEET_NAME, "ExpectedBrowser", 2);
	
	//getting Expected Environment
	env = excel.getCelldata(LOCAL_SHEET_NAME, "ExpectedEnvironment", 2);
	
	//geting Login Credencials and baseURL
	getloginDetails();
	
	
}

/*
This method is used to retrieve Base URL,
User Name and Password from Pass Configuration
file
*/
public static void getloginDetails()
{
	int rowNo = excel.getRow(CONFIG_SHEET_NAME, "Environment", env);
	base_url = excel.getCelldata(CONFIG_SHEET_NAME, "Base URL", rowNo);
	userName = excel.getCelldata(CONFIG_SHEET_NAME, "User Name", rowNo);
	password = excel.getCelldata(CONFIG_SHEET_NAME, "Password", rowNo);
}




}
