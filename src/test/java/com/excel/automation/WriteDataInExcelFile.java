package com.excel.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class WriteDataInExcelFile {
    FileInputStream inputStream;
    Workbook workbook;
    Sheet sheet;

    @Test
    public void writeData() throws IOException {
        // get the file path
        File file = new File("C:\\Users\\HP\\Desktop\\ExcelData\\Data1.xlsx");
        //get the filename
        String fileName = file.getName();
        // get the extension of the file
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        inputStream = new FileInputStream(file);
        // check if the extension is xlsx --> then create of XSSFWorkBook
        //else create object of HSSFWorkbook
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        // check if the sheet is present with cyber name
        //if it presents then use ass is else create new sheet
        if (workbook.getSheet("cyber") != null) {
            sheet = workbook.getSheet("cyber");
        } else {
            // create sheet
            sheet = workbook.createSheet("cyber");
        }
        for (int i = 0; i < 10; i++) {
            //create rows
            Row row = sheet.createRow(i);
            for (int j = 0; j < 2; j++) {
                Cell cell = row.createCell(j);
                if (j == 0) {
                    // add data in cell
                    cell.setCellValue("selenium" + i);
                } else {
                    //add data in cell
                    cell.setCellValue("API" + i);
                }
                //Write data in file
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                System.out.println("Data written successfully in excel file...");
                workbook.close();
                outputStream.close();


            }

        }
    }
}
