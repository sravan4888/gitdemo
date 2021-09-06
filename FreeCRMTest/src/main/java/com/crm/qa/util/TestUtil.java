package com.crm.qa.util;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	static String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\testdata\\datadriven.xlsx";
	static String reportpath = System.getProperty("user.dir")+"\\newreport\\index.html"; 
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	
		
	public Object[][] data(String sheetName)
	{
		
		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet(sheetName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int rowcnt = sheet.getLastRowNum();
		int colcnt = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int r=0; r < rowcnt; r++)
		{
			XSSFRow row = sheet.getRow(r+1);
			for(int c=0; c < colcnt; c++)
			{
				XSSFCell cell = row.getCell(c);
				obj[r][c] = cell.getStringCellValue();
				
			}
		}
		return obj;
	}
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public String reportPath()
	{
		return this.reportpath;
	}

}
