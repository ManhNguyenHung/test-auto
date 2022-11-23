package Utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelConfig {

    private XSSFWorkbook wb;
    private XSSFSheet sh;
    private FileInputStream fileIn;

    public ExcelConfig(String excelPath) {
        try {
            File file = new File(excelPath);
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public int getNumRow(int sheetIndex) {
        sh = wb.getSheetAt(sheetIndex);
        return sh.getLastRowNum();
    }

    public int getColNum(int sheetIndex) {
        sh = wb.getSheetAt(sheetIndex);
        return sh.getRow(0).getLastCellNum();
    }

    public String getDataValue(int sheetIndex, int rowNum, int colNum) {
        sh = wb.getSheetAt(sheetIndex);
        DataFormatter df = new DataFormatter();
        try {
            return df.formatCellValue(sh.getRow(rowNum).getCell(colNum));
        } catch (NullPointerException e) {
            return "";
        }
    }

    public Object[][] data(int sheetIndex) {
        int rowNum = getNumRow(sheetIndex);
        int colNum = getColNum(sheetIndex);
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                obj[currentRow][j] = getDataValue(sheetIndex, i, j);
                Log4j.info("Value: " + obj[currentRow][j]);
            }
            currentRow++;
        }
        return obj;
    }


}