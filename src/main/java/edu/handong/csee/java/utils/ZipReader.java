package edu.handong.csee.java.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {

	public static ArrayList<String> readFileInZip1(String path) throws SeveralExceptions {
		
		File dir = new File(path);
		File[] list = dir.listFiles();
		
	
		ArrayList<String> readZip1 = new ArrayList<String>();
		ZipFile zipFile;

		for(int i = 0; i < list.length; i++) {
			try {
				File file = list[i];
				
				String name1 = file.getName();
				name1 = name1.replace(".zip", "");
				zipFile = new ZipFile(file, "euc-kr");
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
				
				while (entries.hasMoreElements()) {
					ZipArchiveEntry entry = entries.nextElement();
					InputStream stream = zipFile.getInputStream(entry);
					
					ExcelReader myReader = new ExcelReader();
					
					for (String value : myReader.getData1(stream)) {
						if (entry.getName().contains("¿ä¾à¹®")) {
							value = name1 + "," + value;
							System.out.println(value);
							readZip1.add(value);
						} else {
							continue;
						}
					}
				}
				zipFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return readZip1;
	}
	
	public static ArrayList<String> readFileInZip2(String path) throws SeveralExceptions {
		
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		ArrayList<String> readZip2 = new ArrayList<String>();
		ZipFile zipFile;
		
		for(int i = 0; i < list.length; i++) {
			try {
				File file = list[i];
				
				String name1 = file.getName();
				name1 = name1.replace(".zip", "");
				zipFile = new ZipFile(file, "euc-kr");
				Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();
			
				while (entries.hasMoreElements()) {
					ZipArchiveEntry entry = entries.nextElement();
					InputStream stream = zipFile.getInputStream(entry);
					
					ExcelReader myReader = new ExcelReader();
				
					for (String value : myReader.getData2(stream)) {
						if (entry.getName().contains("Ç¥")) {
							value = name1 + "," + value;
							System.out.println(value);
							readZip2.add(value);
						} else {
							continue;
						}
					}
				}
				zipFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return readZip2;
	}
}
