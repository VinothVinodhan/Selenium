package mylearningAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This program illustrates how to update an existing Microsoft Excel document.
 * Append new rows to an existing sheet.
 *
 * @author www.codejava.net
 *
 */
public class WriteToExcel {
	public static void writeList(String trainingName) throws InterruptedException {
		String excelFilePath = System.getProperty("user.dir") + "\\List.xlsx";

		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);

			Sheet sheet = workbook.getSheetAt(0);

			Object[][] bookData = { { "" + trainingName + "" }

			};

			int rowCount = sheet.getLastRowNum();

			for (Object[] aBook : bookData) {
				Row row = sheet.createRow(++rowCount);

				int columnCount = 0;

				Cell cell = row.createCell(columnCount);
				cell.setCellValue(rowCount);

				for (Object field : aBook) {
					cell = row.createCell(++columnCount);
					if (field instanceof String) {
						cell.setCellValue((String) field);
					} else if (field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "\\List.xlsx");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			// System.out.println("Done..!");

		} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {
			ex.printStackTrace();
		}
	}

	public static void sendEmail() {
		String filePath = System.getProperty("user.dir") + "\\Training_Tracker.vbs";
		Runtime rt = Runtime.getRuntime();
		try {
			System.out.println("Running..!");
			Runtime.getRuntime().exec("wscript " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
