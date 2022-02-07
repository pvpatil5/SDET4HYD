package practice_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("../com.crm.Vtiger/SDET4.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		String value=workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(value);
		
	}
}
