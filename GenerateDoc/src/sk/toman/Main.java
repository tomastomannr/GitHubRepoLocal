package sk.toman;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagmentDB managmentDB = new ManagmentDB();
		managmentDB.ConnectServer();
		
		MainWindow mainWindow = new MainWindow(managmentDB.getDatabases());
		mainWindow.setVisible(true);
		
		ArrayList<String> databaseNames = managmentDB.getDatabases();
		System.out.println("Dostupne databazy : "+databaseNames);
		System.out.println("Zvolena DB "+ databaseNames.get(4));
		ArrayList<String> tabulky = managmentDB.getTableNames(databaseNames.get(4));
		System.out.println("Tabulky v DB "+tabulky);
		System.out.println("Zvolena tabulka " + tabulky.get(0));
		System.out.println("Stlpce "+managmentDB.getTableColNames(databaseNames.get(4), tabulky.get(0)));		
		//System.out.println("Idem ziskat column names pre "+tableNames.get(0));
		//System.out.println(managmentDB.getTableColNames(tableNames.get(0)));
		
		
		
		
		
		
		
		
		
		
		
/*		
		Workbook wb = new XSSFWorkbook();//HSSFWorkbook();
		Sheet s1 = wb.createSheet("List è 1.");
		Sheet s2 = wb.createSheet("List è 2.");
		Sheet s3 = wb.createSheet("List è 3.");
		
		Row r = null;
		Cell c = null;
		
		Font f = wb.createFont();
		Font f2 = wb.createFont();
		
		CellStyle cs = wb.createCellStyle();
		CellStyle cs2 = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		
		
		//set font 1 to 12 point type
		f.setFontHeightInPoints((short) 12);
		//make it blue
		f.setColor( (short)0xc );
		// make it bold
		//arial is the default font
		f.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		//set font 2 to 10 point type
		f2.setFontHeightInPoints((short) 10);
		//make it red
		f2.setColor( (short)Font.COLOR_RED );
		//make it bold
		f2.setBoldweight(Font.BOLDWEIGHT_BOLD);
		
		
		f2.setStrikeout( true );
		
		//set cell stlye
		cs.setFont(f);
		//set the cell format 
		cs.setDataFormat(df.getFormat("#,##0.0"));

		//set a thin border
		cs2.setBorderBottom(cs2.BORDER_THIN);
		//fill w fg fill color
		cs2.setFillPattern((short) CellStyle.SOLID_FOREGROUND);
		//set the cell format to text see DataFormat for a full list
		cs2.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));

		// set the font
		cs2.setFont(f2);

		for(int i = 0;i<20;i++){
			r = s1.createRow(i);
			c = r.createCell(0);
			c.setCellValue(i + " " + s1.getSheetName());
			r = null;
			c = null;
			
			r = s2.createRow(i);
			c = r.createCell(0);
			c.setCellValue(i + " " + s2.getSheetName());
			r = null;
			c = null;
			
			r = s3.createRow(i);
			c = r.createCell(0);
			c.setCellValue(i + " " + s3.getSheetName());
			r = null;
			c = null;
		}
		
		try {
			FileOutputStream out = new FileOutputStream("workbook.xlsx");
			wb.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		
		
		
		
		
		
	}

}
