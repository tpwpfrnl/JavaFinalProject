package edu.handong.csee.java.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.InputStream; 
import java.util.ArrayList; 

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import edu.handong.csee.java.datamodel.Summary;

public class ExcelReader {

	public ArrayList<String> getData(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();

		try (InputStream inp = is) {

			XSSFWorkbook wb = new XSSFWorkbook(inp);
			XSSFSheet sheet = wb.getSheetAt(0);
			
			int rows = sheet.getPhysicalNumberOfRows();
			for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //down
				if(row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for(int columnIndex = 0; columnIndex <= cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex); //right
						if (cell == null) {
							cell = row.createCell(10);				
						}
						values.add(cell.getStringCellValue());
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return values;
	}
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName) {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("자료수집양식");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		
		try {
//			for(String line:lines) {
//				cell.setCellValue(line);				
//			}
//			FileOutputStream outPutStream = new FileOutputStream(targetFileName);
//			wb.write(outPutStream);
//			outPutStream.close();
			File file = new File(targetFileName);
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(file));
//			bufWrite.write("제목,요약문 (300자 내외),핵심어 (keyword, 쉽표로 구분),조회날짜,실제자료조회 출처 (웹자료링크),원출처 (기관명 등),제작자 (Copyright 소유처)");
			bufWrite.newLine();
			for(String line:lines) {
				bufWrite.write(line);
				bufWrite.newLine();
			}
			bufWrite.flush();
			bufWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
