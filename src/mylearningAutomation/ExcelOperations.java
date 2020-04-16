package mylearningAutomation;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelOperations {
	public static void main(String args[]) {
		try {
			System.out.println("Value Received: " + getInputData("UserName"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getInputData(String getParameterValue) throws IOException {
		try {
			String sheetName = "Credentials";
			String obtainedValue = null;
			FileInputStream file = new FileInputStream(
					new File(System.getProperty("user.dir") + "\\", "Credentials.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			Iterator<Row> rowIterator = sheet.iterator();
			DataFormatter formatter = new DataFormatter();
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 0; i < rowCount + 1; i++) {
				Row row = sheet.getRow(i);
				int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
				for (int j = 0; j < columnCount; j++) {
					Cell colValue = sheet.getRow(i).getCell(j);
					if (colValue != null) {
						int k = 1;
						Cell key = sheet.getRow(i).getCell(j);
						Cell keyValue = sheet.getRow(k).getCell(j);
						if (keyValue != null) {
							if (key.toString().trim().equals(getParameterValue.trim())) {
								switch (evaluator.evaluateInCell(keyValue).getCellType()) {
								case Cell.CELL_TYPE_NUMERIC:
									obtainedValue = formatter.formatCellValue(keyValue);
									// System.out.print(obtainedValue + "\n");
									return obtainedValue;
								case Cell.CELL_TYPE_STRING:
									obtainedValue = keyValue.getStringCellValue();
									// System.out.print(keyValue.getStringCellValue()
									// + "\n");
									return obtainedValue;
								case Cell.CELL_TYPE_FORMULA:
									break;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getParameterValue = "noValueDefined.";
	}
}
