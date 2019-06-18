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
			String linee = "";
			
			int rows = sheet.getPhysicalNumberOfRows();
			for(int rowIndex = 1; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex); //down
				if(row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for(int columnIndex = 0; columnIndex <= cells; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex); //right
						String val = "";
						if (cell == null) {
							cell = row.createCell(10);				
						}
						switch(cell.getCellType()) {
						case ERROR:
							val = cell.getErrorCellValue() + "";
							break;
						case STRING:
							val = cell.getStringCellValue() + "";
							break;
						case NUMERIC:
							val = cell.getNumericCellValue() + "";
							break;
						}
						if(val.contains(",")) {
							val = val.replaceAll(",", " ");
						}
						linee += val + ",";
						
					}
					values.add(linee);
					linee = "";
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
	
	public static void writeAFile1(ArrayList<String> lines, String targetFileName) {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("자료수집양식");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		
		targetFileName = targetFileName.replace(".csv", "1.csv");
		
		try {
//			for(String line:lines) {
//				cell.setCellValue(line);				
//			}
//			FileOutputStream outPutStream = new FileOutputStream(targetFileName);
//			wb.write(outPutStream);
//			outPutStream.close();
			File file = new File(targetFileName);
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(file));

			for(String line:lines) {
				bufWrite.write(line);
				bufWrite.newLine();
			}
			bufWrite.flush();
			bufWrite.close();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeAFile2(ArrayList<String> lines, String targetFileName) {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("자료수집양식");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		
		targetFileName = targetFileName.replace(".csv", "2.csv");
		
		try {
			File file = new File(targetFileName);
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(file));

			for(String line:lines) {
				bufWrite.write(line);
				bufWrite.newLine();
			}
			bufWrite.flush();
			bufWrite.close();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
