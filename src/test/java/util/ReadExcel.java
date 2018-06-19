package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcel {
	
	//public static void main(String[] args) throws IOException {
	@DataProvider(name = "getLoginData")
	public static Object[][] readExcelContents() throws IOException{
		
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook  wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		int rowCount = sh.getLastRowNum();
		System.out.println("No of rows are: " + rowCount);
		
		Object[][] obj = new Object[rowCount][5];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow currentRow = (XSSFRow) sh.getRow(i);
			obj[i - 1][0] = currentRow.getCell(0).getStringCellValue();
			obj[i - 1][1] = (long) currentRow.getCell(1).getNumericCellValue()
					+ "";
			obj[i - 1][2] = currentRow.getCell(2).getStringCellValue();
			obj[i - 1][3] = (int) currentRow.getCell(3).getNumericCellValue();
			obj[i - 1][4] = (int) currentRow.getCell(4).getNumericCellValue();
		}

		
		
		/*for( int i =0 ; i<=rowCount ;i++)
		{
			
			Row row = sh.getRow(i);
			
			for( int j =0 ; j <row.getLastCellNum(); j++)
			{
				
				System.out.print(row.getCell(j).getStringCellValue() + "||");
			}
			
			System.out.println();
		}*/
		return null;
		
		
	}

}
