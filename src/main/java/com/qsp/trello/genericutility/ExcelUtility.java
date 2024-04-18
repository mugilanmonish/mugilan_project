package com.qsp.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtility {
	public String readTheString(String SheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String value = cell.getStringCellValue();
		return value;
	}
	public double readTheDoubleNumericData(String SheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		double value = cell.getNumericCellValue();
		return value;
	}
	public long readTheLongNumericData(String SheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		long value = (long) cell.getNumericCellValue();
		return value;
	}
}
