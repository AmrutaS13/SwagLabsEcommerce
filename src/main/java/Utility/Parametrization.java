package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

	public static String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException     {
		
		  FileInputStream file = new  FileInputStream("C:\\Users\\HMGAS-PINGLAS\\eclipse-workspace\\SwagLabs\\src\\test\\resources\\TestData.xlsx");		  
		  String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
			
		  return value;
		}

	}


