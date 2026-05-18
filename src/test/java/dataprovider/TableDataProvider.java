package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class TableDataProvider {
	 @DataProvider(name = "tableData")
	    public Object[][] getTableData() throws IOException {

	        String path = System.getProperty("user.dir")
	                + "/src/test/resources/DataForTest/TableData.xlsx";

	        return ExcelUtils.getExcelData(path, "Sheet1");
	    }

}
