package edu.handong.csee.java.utils;

import java.io.IOException; 
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration; 

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry; 
import org.apache.commons.compress.archivers.zip.ZipFile; 

public class ZipReader { 
 	
 	public static ArrayList<String> readFileInZip(String path) {
 		ArrayList<String> readZip = new ArrayList<String>();
 		ZipFile zipFile; 
		try { 
			zipFile = new ZipFile(path); 
 			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries(); 
 
 		    while(entries.hasMoreElements()){ 
 		    	ZipArchiveEntry entry = entries.nextElement(); 
 		        InputStream stream = zipFile.getInputStream(entry); 
 		     
 		        ExcelReader myReader = new ExcelReader(); 
 		         
 		        for(String value:myReader.getData(stream)) { 
// 		        	System.out.println(value); 
 		        	readZip.add(value);
 		        } 
 		    } 
 		} catch (IOException e) { 
 			// TODO Auto-generated catch block 
 			e.printStackTrace(); 
 		}
		return readZip;
 	} 
 } 

