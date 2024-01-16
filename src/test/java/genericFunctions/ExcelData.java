package genericFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("deprecation")
public class ExcelData {
	public FileInputStream fis = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String xlFilePath = Constants.PS_DATA_XLS_PATH;

	HashMap<String, String> map = new HashMap<String, String>();

	@SuppressWarnings("unused")
	public HashMap<String, String> getCellData(String scenarioName) throws IOException {

		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		int col_Num = -1;
		int row_Num = 0;
		sheet = workbook.getSheetAt(0);
		for (int j = 0; j < sheet.getLastRowNum(); j++) {
			if (sheet.getRow(j).getCell(0).getStringCellValue().trim().equalsIgnoreCase(scenarioName.trim())) {
				row = sheet.getRow(j + 1);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					String key = row.getCell(i).getStringCellValue().trim();
					row = sheet.getRow(j + 2);
					String Value = row.getCell(i).getStringCellValue().trim();
					map.put(key, Value);
					row = sheet.getRow(j + 1);
				}
			}
		}
		return map;

	}

}
