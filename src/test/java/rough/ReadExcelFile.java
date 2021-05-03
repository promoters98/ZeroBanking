package rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		
		// specify the file location
		File src = new File ("C:\\Users\\ghaur\\eclipse-workspace\\automationtesting\\src\\test\\resources\\exceldata\\testData.xlsx");
		
		//load the file
		FileInputStream fis = new FileInputStream(src);
		
		//load workbook from excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//loading the sheet 1
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//setting variable for data in row 1, column 1
		String data = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);
		
		wb.close();
		
	}

}
