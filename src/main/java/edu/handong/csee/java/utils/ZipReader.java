package edu.handong.csee.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

import edu.handong.csee.java.datamodel.Summary;

public class ZipReader {

	public static ArrayList<String> readFileInZip(String path) {
		ArrayList<String> readZip1 = new ArrayList<String>();
		ArrayList<String> readZip2 = new ArrayList<String>();
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(path, "euc-kr");
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

			while (entries.hasMoreElements()) {
				ZipArchiveEntry entry = entries.nextElement();
				InputStream stream = zipFile.getInputStream(entry);

				ExcelReader myReader = new ExcelReader();

				for (String value : myReader.getData(stream)) {
					System.out.println(value);
//					if (entry.getName().contains("요약문")) {
//						readZip1.add(value);
//						return readZip1;
//					} else if (entry.getName().contains("표")) {
						readZip2.add(value);
//					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readZip2;
	}
}
