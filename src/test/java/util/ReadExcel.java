package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	static Logger Log = Logger.getLogger(ReadExcel.class);
	
	//public static void main(String[] args) throws IOException {
	@DataProvider(name = "LoginDP")
	
	public static Object[][] readExcelContents() throws IOException{
	
		Log.info("Reading Login data from excel");
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook  wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("loginTC");
		
		int rowCount = sh.getLastRowNum();
		System.out.println("No of rows are: " + rowCount);
		
		Object[][] obj = new Object[rowCount][2];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow currentRow = (XSSFRow) sh.getRow(i);
			obj[i - 1][0] = currentRow.getCell(0).getStringCellValue();
			obj[i - 1][1] = currentRow.getCell(1).getStringCellValue();
			//obj[i - 1][2] = currentRow.getCell(2).getStringCellValue();
			//obj[i - 1][3] = currentRow.getCell(3).getNumericCellValue();
			//obj[i - 1][4] = currentRow.getCell(4).getNumericCellValue();
		}
		fis.close();
		
		
		/*for( int i =0 ; i<=rowCount ;i++)
		{
			
			Row row = sh.getRow(i);
			
			for( int j =0 ; j <row.getLastCellNum(); j++)
			{
				
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			
			System.out.println();
		}*/
		
		return obj;
		
		
	}
	
	@DataProvider(name = "AddEmp")
	public static Object[][] readExcelContentsForAddNewEmp() throws IOException{
		Log.info("Reading data for Add Empl");
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook  wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("AddEmp");
		
		int rowCount = sh.getLastRowNum();
		System.out.println("No of rows are: " + rowCount);
		
		Object[][] obj = new Object[rowCount][4];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow currentRow = (XSSFRow) sh.getRow(i);
			obj[i - 1][0] = currentRow.getCell(0).getStringCellValue();
			obj[i - 1][1] = currentRow.getCell(1).getStringCellValue();
			obj[i - 1][2] = currentRow.getCell(2).getStringCellValue();
			obj[i - 1][3] = currentRow.getCell(3).getStringCellValue();
			//obj[i - 1][4] = currentRow.getCell(4).getNumericCellValue();
		}
		fis.close();
		
		
		/*for( int i =0 ; i<=rowCount ;i++)
		{
			
			Row row = sh.getRow(i);
			
			for( int j =0 ; j <row.getLastCellNum(); j++)
			{
				
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			
			System.out.println();
		}*/
		
		return obj;
		
		
	}


}
