package com.OH.libraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Libraries 
{
	static String Excel_Path = System.getProperty("user.dir")+"\\Excel_Data.xlsx" ;
	static Workbook Wb;
	
	public static String Create_Excel() throws Throwable
		{
			Wb = new HSSFWorkbook();
			Wb.createSheet("Sheet1").createRow(0).createCell(0);
			FileOutputStream fout = new FileOutputStream(Excel_Path);
			Wb.write(fout);
			Wb.close();
			return Excel_Path;
		}
	
	public static void Write_Excel() throws Throwable
		{
			FileInputStream fin=new FileInputStream(Excel_Path);
			Wb=WorkbookFactory.create(fin);
			Sheet sh = Wb.getSheet("Sheet1");
			Row rw_obj = sh.createRow(1);
			rw_obj.createCell(1).setCellValue("Arti");
			FileOutputStream fout = new FileOutputStream(Excel_Path);
			Wb.write(fout);
			Wb.close();
		}
	
	public static String Read_Excel(String col_Name) throws Throwable
		{
		    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Excel_Read.xlsx"); 
            Wb=WorkbookFactory.create(file);
			Sheet sh = Wb.getSheet("Sheet1");
	        Row row = sh.getRow(0);
	        int col_num = 0;
	 
	        for(int i=0; i < row.getLastCellNum(); i++)
	        {
	            if(row.getCell(i).toString().trim().equals(col_Name))
	                col_num = i;
	        }	 
	        row = sh.getRow(1);
	        Cell cell = row.getCell(col_num);
	        return cell.toString();	         
		}
	
	public static void Excel_Reporter(String Step_Name,String Step_details,String Expected,String Actual,String Status) throws Throwable
		{
		    String[] Report = {"Step_Name","Step_details","Expected","Actual","Status"};
			FileInputStream fin=new FileInputStream(Excel_Path);
			Wb=WorkbookFactory.create(fin);
			Sheet sh = Wb.getSheet("Sheet1");
			Row rw_obj = sh.createRow(0);
			int Row_cnt = sh.getLastRowNum();
			for (int a=0;a<=4;a++)
			{
				rw_obj.createCell(a).setCellValue(Report[a]);
			}	
			
			String[] Report1 = {Step_Name,Step_details,Expected,Actual,Status};
			Row rw_obj1 = sh.createRow(Row_cnt+1);
			for (int j=0;j<=4;j++)
			{
				rw_obj1.createCell(j).setCellValue(Report1[j]);
			}
			
			FileOutputStream fout = new FileOutputStream(Excel_Path);
			Wb.write(fout);
			Wb.close();
		}

	
}
			  
	
	


	
	


