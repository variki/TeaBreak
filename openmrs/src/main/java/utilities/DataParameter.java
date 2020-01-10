package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameter extends Constants{
	
	@Test(dataProvider="getData")
	public void testData(Hashtable<String,String> data){
		
			
		//System.out.println(data.get("Runmode")+"---"+data.get("customer")+"---"+data.get("currency"));
		
		System.out.println(data.get("P1")+"---"+data.get("P2")+"---"+data.get("P2"));
	}
	
	@DataProvider
	public static Object[][] getData(Method m)
	{
		
		ExcelUtilities excel = new ExcelUtilities(Constants.TEST_DATA);
		String sheetName = m.getName();
		int dataRowCount = excel.getRowCount(sheetName);
		System.out.println();
		// Getting total use full data 
		int dataStartRow =1;
		int dataToUse = 0;
		while(!excel.getCelldata(sheetName, 0, dataStartRow+dataToUse).equals(""))
		{		
			System.out.println(excel.getCelldata(sheetName, 0, dataStartRow+dataToUse));
			dataToUse++;
		}
		// Getting total column
		int columnRow = 0; 
		while(!excel.getCelldata(sheetName, columnRow, 0).equals(""))
		{
			System.out.println(excel.getCelldata(sheetName, columnRow, 0));
			columnRow++;
		}
		
		// Creating return object with no of Userfull data
		Object[][] data = new Object[dataToUse][1];
		
		//Setting data to object
		int count = 0;
		for(int rNum=dataStartRow;rNum<=dataToUse;rNum++)
		{
			Hashtable<String,String> table = new Hashtable<String,String>();
			
			for(int cNum=0;cNum<columnRow;cNum++)
			{
				String testData = excel.getCelldata(sheetName, cNum, rNum);
				String columnName = excel.getCelldata(sheetName, cNum, 0);
				table.put(columnName, testData);
			}
			data[count][0] = table;
			count++;
		}
		
		
		return data;
		
		
	}

}
