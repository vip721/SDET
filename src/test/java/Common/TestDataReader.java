package Common;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDataReader {
    private static final String FILE_PATH = System.getProperty("user.dir")+"\\src\\test\\java\\excel\\testdata.xlsx";
    private static final String SHEET_NAME = "Sheet1";

    public static String readData(String key, int rowIndex) {
        String value = null;
        try (FileInputStream file = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            Row headerRow = sheet.getRow(0);

            int colIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                if (headerRow.getCell(i).getStringCellValue().equals(key)) {
                    colIndex = i;
                    break;
                }
            }

            if (colIndex != -1) {
                Row dataRow = sheet.getRow(rowIndex);
                if (dataRow != null) {
                    Cell cell = dataRow.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    value = cell.toString();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }


}
