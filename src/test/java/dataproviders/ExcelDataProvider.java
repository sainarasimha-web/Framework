package dataproviders;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class ExcelDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        String filePath = "src/test/resources/testdata/LoginTestData.xlsx";

        ExcelUtils.loadExcel(filePath, "Login");

        int rows = ExcelUtils.getRowCount();
        int columns = ExcelUtils.getColumnCount();

        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                data[i][j] = ExcelUtils.getCellData(i + 1, j);
            }
        }

        ExcelUtils.closeExcel();

        return data;
    }
}