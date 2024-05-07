package com.excel.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandling {
    FileInputStream inputStream;
    Workbook workbook;

    public Workbook getWorkbook(String filepath) throws IOException {
        File file = new File(filepath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        inputStream = new FileInputStream(file);

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

    @DataProvider
    public Object[][] getExcelData() throws IOException {
        Workbook workbook = getWorkbook("C:\\Users\\HP\\Desktop\\ExcelData\\Data1.xlsx");
        Sheet sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total Rows " + totalRows);

        Row row;
        row = sheet.getRow(0);
        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("Total Columns " + totalColumns);

        Object[][] data = new Object[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++) {
                Cell cell = row.getCell(j);
                Object var = null;
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            var = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            var = cell.getNumericCellValue();
                            break;
                        case BLANK:
                            var = ""; // Handle blank cells
                            break;
                        case BOOLEAN:
                            var = cell.getBooleanCellValue();
                            break;
                    }
                    data[i - 1][j] = var;
                    System.out.print(var + " ");
                }
            }
            System.out.println();
        }
        return data;
    }

    public void closeInstance() throws IOException {
        workbook.close();
        inputStream.close();
    }

    @Test(dataProvider = "getExcelData")
    public void verifyExcelData(String var1, String var2) {
        System.out.println(var1 + " " + var2);
    }

    @AfterClass
    public void tearDown() throws IOException {
        closeInstance();
    }
}
