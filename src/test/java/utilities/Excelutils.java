package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	public static String getCellValue(String xlName, String sheetName, int row, int column) throws IOException {
		
		FileInputStream fis = new FileInputStream(xlName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else {
			return cell.getRawValue();
		}
	}
	

public static int getRowCount(String xlName,String  sheetName) throws IOException {
	
	FileInputStream fis = new FileInputStream(xlName);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sh = wb.getSheet(sheetName);
	
	int rowCount = sh.getLastRowNum();
	return rowCount;
	
}

}