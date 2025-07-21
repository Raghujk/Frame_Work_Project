package Com_Luma_Utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_Utiles {
	
	public static FileInputStream fs;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;
	public static FileOutputStream fo;
	
	
	public static int GetRowCount(String ExcelFile , String Excelsheet) throws IOException {
		fs = new FileInputStream(ExcelFile);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(Excelsheet);
		int RowCount = sheet.getLastRowNum();
		wb.close();
		fs.close();
		return RowCount;
		
	}
	
	public static int GetCellCount(String ExcelFile , String Excelsheet ,int Rownum) throws IOException {
		fs = new FileInputStream(ExcelFile);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(Excelsheet);
		Row = sheet.getRow(Rownum);
		int CellCount = Row.getLastCellNum();
		return CellCount;
		
	}
	
	public static String  GetCellData(String ExcelFile , String Excelsheet ,int Rownum ,int Cellnum) throws IOException {
		fs = new FileInputStream(ExcelFile);
		wb = new XSSFWorkbook(fs);
		sheet = wb.getSheet(Excelsheet);
		Row = sheet.getRow(Rownum);
		Cell =Row.getCell(Cellnum);
		String Data;
		try {
			DataFormatter format = new DataFormatter();
			String CellData = format.formatCellValue(Cell);
			return CellData;
		} catch (Exception e) {
			Data = "";
		}
		wb.close();
		fs.close();
		return Data;
		
	}
	public void setcelldata(String ExcelFile,String Excelsheet,int Rownum, int Cellnum,String Data) throws IOException {
		fs = new FileInputStream(ExcelFile);
		wb = new XSSFWorkbook(fs);
		sheet  = wb.getSheet(Excelsheet);
		Row = sheet.getRow(Rownum);
		Cell = Row.createCell(Cellnum);
		Cell.setCellValue(Data);
		
		fo = new FileOutputStream(ExcelFile);
		wb.write(fo);
		fs.close();
		fo.close();
	}

}
