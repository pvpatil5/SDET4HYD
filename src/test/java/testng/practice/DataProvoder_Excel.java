package testng.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericPac.IAutoConstants;

public class DataProvoder_Excel 
{

	@Test(dataProvider = "read")
	public void readExceldta(Object UN, Object Pwd,Object otp)
	{
		System.out.println(UN +" " +Pwd+" "+otp);
	}

	@DataProvider
	public Object[][] read() throws EncryptedDocumentException, IOException 
	{
		FileInputStream fisFileInputStream = new FileInputStream(IAutoConstants.excelpath);

		Workbook workbook = WorkbookFactory.create(fisFileInputStream);
		int lastrow = workbook.getSheet("Sheet2").getLastRowNum();
		
		short lastcell = workbook.getSheet("Sheet2").getRow(1).getLastCellNum();
		
		System.out.println(lastcell);
		
		Object arr[][]= new Object[lastrow][3];

		for (int i = 0; i < lastrow; i++) 
		{
			arr[i][0]= workbook.getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue();

			arr[i][1]= workbook.getSheet("Sheet2").getRow(i).getCell(1).getStringCellValue();
		
			arr[i][2]= workbook.getSheet("Sheet2").getRow(i).getCell(2).getNumericCellValue();
		}
		return arr;


	}
}
