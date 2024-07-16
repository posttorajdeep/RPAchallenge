package Utils;

import PageObjects.BaseTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;

public class ExcelUtility extends BaseTest {

    public HashMap map ;

    public void writeMessageToExcel(String msg, File file){
        try (FileInputStream fis = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row = sheet.getRow(11);
            if(row == null){
                row = sheet.createRow(11);
            }
            XSSFCell cell = row.getCell(0);
            if(cell == null){
                cell = row.createCell(0);
            }
            cell.setCellValue(msg);

            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public HashMap readDataFromExcel(int rowNum)  {

        try(FileInputStream fis = new FileInputStream(downloadFilePath+"\\challenge.xlsx"))
        {

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            map = new HashMap();
            map.put("firstName", sheet.getRow(rowNum).getCell(0).getStringCellValue());
            map.put("lastName", sheet.getRow(rowNum).getCell(1).getStringCellValue());
            map.put("companyName", sheet.getRow(rowNum).getCell(2).getStringCellValue());
            map.put("roleInCompany", sheet.getRow(rowNum).getCell(3).getStringCellValue());
            map.put("address", sheet.getRow(rowNum).getCell(4).getStringCellValue());
            map.put("email", sheet.getRow(rowNum).getCell(5).getStringCellValue());
            map.put("phoneNumber", sheet.getRow(rowNum).getCell(6).getRawValue());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return map;

    }
}
