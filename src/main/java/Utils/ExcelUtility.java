package Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class ExcelUtility {
    private String filePath = "";
    public HashMap dataMap = new HashMap();

    public ExcelUtility(String filePath){
        this.filePath = filePath;
    }

    public void readDataFromExcel(String filePath) {

        try(FileInputStream fis = new FileInputStream(filePath))
        {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet){

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
