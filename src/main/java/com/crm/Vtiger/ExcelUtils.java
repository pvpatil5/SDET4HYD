package com.crm.Vtiger;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
/**
 * 
 * @param sheetname
 * @param rowno
 * @param cellno
 * @return given cell value
 * @throws EncryptedDocumentException
 * @throws IOException or Null Pointer exception
 */
	public String readDatafromExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);

		return 	WorkbookFactory.create(fis)
				.getSheet(sheetname)
				.getRow(rowno)
				.getCell(cellno)
				.getStringCellValue();
	}

	public String readDatafromExcel(String path,String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis = new FileInputStream(path);

		return 	WorkbookFactory.create(fis)
				.getSheet(sheetname)
				.getRow(rowno)
				.getCell(cellno)
				.getStringCellValue();
	}

}
