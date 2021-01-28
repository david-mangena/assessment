package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromexcel {

    public String read_data_from_execl() throws IOException {

        FileInputStream file = new FileInputStream("src/main/resources/ddt.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheet("Sheet1");
//        XSSFRow row = sheet.getRow(1);
//        XSSFCell cell = row.getCell(0);
//        String value = cell.getStringCellValue();

        String value = workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        System.out.println("value "+value);
        return value;
    }
}
