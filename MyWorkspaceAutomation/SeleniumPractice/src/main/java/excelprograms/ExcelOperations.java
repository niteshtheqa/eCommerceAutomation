/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package excelprograms;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author nites
 *
 */
public class ExcelOperations {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		ArrayList<String> data = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(
				"G:\\MyWorkspaceAutomation\\SeleniumPractice\\src\\main\\java\\excelprograms\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();

					if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
						coloumn = k;
					}
					k++;
				}
				while (rows.hasNext()) {
					Row row = rows.next();
					
					if (row.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cellValue = row.cellIterator();
						while (cellValue.hasNext()) {
							Cell c = cellValue.next();
							if (c.getCellType() == CellType.STRING) {
								data.add(c.getStringCellValue());

							} else {
								data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}

		}
		return data;

	}

}
