package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String filePath, String sheetName) {

        try {
            FileInputStream fileInputStream =
                    new FileInputStream(filePath);

            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load Excel file: " + filePath, e);
        }
    }

    public static String getCellData(int row, int column) {

        Cell cell = sheet.getRow(row).getCell(column);

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    public static int getColumnCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public static void closeExcel() {

        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to close Excel workbook", e);
        }
    }
}