package com.AutomationFramework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	
	public static Object[][] fetchTCData(String testcaseName) {
		int sameTCDataSetCount = getSameTCDataSetSize(testcaseName);
		Object[][] obj = new Object[sameTCDataSetCount][1];
		Map<Object, Object> datamap = null;
		int columnToPickCount =0;		
		for (int i = 0; i <sameTCDataSetCount ; i++) 
		{
			datamap = new LinkedHashMap<>();
			for(int j=0;j<BaseTest.workbook.getNumberOfSheets();j++) 
			{
				Sheet sheet = BaseTest.workbook.getSheetAt(j);
				if(sheet!=null) 
				{
										
					int sheetRowsCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
					if(sheetRowsCount!=0) {
						int sheetColumnsCount = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
						if(sheetColumnsCount!=0) 
						{
							if(sheet.getSheetName().contains("StaticData_")) {
								
								for(int rowCount=1;rowCount<=sheetRowsCount;rowCount++) {
									if(sheet.getRow(rowCount)!=null) {
										datamap.put(getCellValue(sheet.getRow(rowCount).getCell(0)).trim(), 
												getCellValue(sheet.getRow(rowCount).getCell(1)).trim());
									}
								}
							}else {
								int sheetSameTCColumnCount = 0;
								
								for(int columnCount=1; columnCount<sheetColumnsCount;columnCount++) 
								{
									if(getCellValue(sheet.getRow(0).getCell(columnCount)).equalsIgnoreCase(testcaseName) &&
											getCellValue(sheet.getRow(1).getCell(columnCount)).equalsIgnoreCase("YES")) 
									{
										if(sheetSameTCColumnCount == columnToPickCount) 
										{
											for(int rowCount=0; rowCount<=sheetRowsCount ; rowCount++) 
											{
												if(sheet.getRow(rowCount)!=null) {
													datamap.put(getCellValue(sheet.getRow(rowCount).getCell(0)).trim(), 
															getCellValue(sheet.getRow(rowCount).getCell(columnCount)).trim());
												}											
											}
											break;										
										}	
										sheetSameTCColumnCount++;	
									}														
								}
							}					
						}
					}
															
				}				
			}
			obj[i][0] = datamap;
			columnToPickCount++;
		}
		
		return obj;
	}
	
	private static int getSameTCDataSetSize(String TestcaseName){
		Sheet sheet = BaseTest.workbook.getSheetAt(0);
		int sheetColumnsCount = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
		int SameTCDataSetCount = 0;
		for(int j=1; j<sheetColumnsCount;j++) {
			if(sheet.getRow(0)!=null && !sheet.getRow(0).toString().isEmpty()) {
				if(getCellValue(sheet.getRow(1).getCell(j))!=null && !getCellValue(sheet.getRow(1).getCell(j)).trim().isEmpty()) {
					if(getCellValue(sheet.getRow(0).getCell(j)).equalsIgnoreCase(TestcaseName) && getCellValue(sheet.getRow(1).getCell(j)).equalsIgnoreCase("YES")){
						SameTCDataSetCount++;
					}
				}
			}			
		} 
		return SameTCDataSetCount;
	}
	
	
	public static String getCellValue(Cell currentCell) {
		if(currentCell!=null){
			if (currentCell.getCellType() == CellType.STRING) {
				return currentCell.getStringCellValue();
			} else if (currentCell.getCellType() == CellType.NUMERIC) {
				currentCell.setCellType(CellType.STRING);
				return String.valueOf(currentCell.getStringCellValue());
			} else if (currentCell.getCellType() == CellType.BOOLEAN) {
				return String.valueOf(currentCell.getBooleanCellValue());
			} else if (currentCell.getCellType() == CellType.BLANK) {
				return "";
			}else {
				return "";
			}
		}else{
			return "";
		}
	}
	

	public static void createOutputExcel(Map<Object, Object> testcaseData, String outputFilePath, String sheetName) throws IOException {

		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(sheetName);
		int iterateCount=0;
		try {
			for( Map.Entry<Object, Object> entry: testcaseData.entrySet()) {				
				//Stores the used data in different rows
				Row headerRow = sheet.createRow(iterateCount);
				headerRow.createCell(0,CellType.STRING);
				headerRow.createCell(1,CellType.STRING);
				headerRow.getCell(0).setCellValue(entry.getKey().toString());
				headerRow.getCell(1).setCellValue(entry.getValue().toString());
				iterateCount++;
			}
		}finally {
			FileOutputStream fileOut = new FileOutputStream(new File(outputFilePath));
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
		}		
	}
	
}
