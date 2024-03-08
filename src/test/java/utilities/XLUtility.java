package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility 
{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getrowCount(String xlfile, String xlSheeet) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheeet);
		int totalrow=ws.getLastRowNum();
		wb.close();
		fi.close();
		return totalrow;
		
	}
	public static int getcellcount(String xlfile, String xlSheeet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheeet);
	    row = ws.getRow(rownum);	
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		
		
		return cellcount;
		
	}
	public static String getcelldata(String xlfile, String xlSheeet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheeet);
	    row = ws.getRow(rownum);	
	    cell=row.getCell(colnum);
	    
	    String data;
	    try {
	    	
	    	//data=cell.toString();
	    	DataFormatter formatter=new DataFormatter();
	    	data=formatter.formatCellValue(cell);
	    	return data;
	    		
	    }
	    catch(Exception e)
	    {
	    	data="";
	    }
	    wb.close();
		fi.close();
		return data;
		
	}
	
	public static void setcelldata(String xlfile, String xlSheeet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheeet);
	    row = ws.getRow(rownum);
	    cell=row.createCell(colnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
		
	}
	
	
	
	
}
