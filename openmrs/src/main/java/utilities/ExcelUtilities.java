package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public String path;
	public FileInputStream fileInput = null;
	public FileOutputStream fileout = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelUtilities(String path) {
		this.path = path;
		try {
			fileInput = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInput);
			fileInput.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// return Excel row number
	public int getRowCount(String sheetName) {

		int index = isSheetExists(sheetName);
		sheet = workbook.getSheetAt(index);
		int rowNumber = sheet.getLastRowNum() + 1;
		return rowNumber;

	}
	
	public int getRow(String sheetName, String columnName,String searchValue)
	{
		int rowcount = getRowCount(sheetName);
		for(int count = 1; count<=rowcount;count++)
		{
			if(getCelldata(sheetName, columnName, count) == searchValue)
			{
				rowcount =  count;
			}else {
				rowcount = -1;
				
			}
		}
		
		return rowcount;
		
	}

	// return Excel cell data
	public String getCelldata(String sheetName,String columnName, int rowNum) {
		String value="";
		try {			
				if(rowNum <=0)
				{
					return "";
				}
				int index = isSheetExists(sheetName);
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(0);
				int column_number = isColumnExists(sheetName, columnName, row);
				row = sheet.getRow(rowNum);
				cell = row.getCell(column_number);
				switch(cell.getCellType())
				{
				case NUMERIC:
					value = String.valueOf(cell.getNumericCellValue());
					break;
				case BLANK:
					value = "";
					break;
				case BOOLEAN:
					value =  String.valueOf(cell.getBooleanCellValue());
					break;
				default:
					value = cell.getStringCellValue();
					break;
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		return value;	
			
		}
	
	// return Excel cell data
		public String getCelldata(String sheetName,int columnNum, int rowNum) {
			String value="";
			try {			
					if(rowNum <=0)
					{
						return "";
					}
					int index = isSheetExists(sheetName);
					sheet = workbook.getSheetAt(index);
					row = sheet.getRow(rowNum);
					cell = row.getCell(columnNum);
					switch(cell.getCellType())
					{
					case STRING:
						value = cell.getStringCellValue();
						break;
					case NUMERIC:
						value = String.valueOf(cell.getNumericCellValue());
						break;
					case BLANK:
						value = "";
						break;
					case BOOLEAN:
						value =  String.valueOf(cell.getBooleanCellValue());
						break;
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
			return value;	
				
			}

	// check the sheet exist or not
	public int isSheetExists(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {

		}
		return index;
	}

	// check the column exist or not
	public int isColumnExists(String sheetName, String columnName, XSSFRow row) {
		int column_Number = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim()))
				column_Number = i;
		}
		if (column_Number <= 0) {

		}
		return column_Number;
	}

	public static void main(String argp[]) {
		 ExcelUtilities excel = new ExcelUtilities(System.getProperty("user.dir")+"\\src\\test\\resources\\passData\\PassData_Configuration.xlsx");
		 
	}

}
