package components;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

    public String ReadExcel(int row, int cell) throws Exception {

        String filepath = "C:\\Users\\A215776\\Workspace\\Mobile\\AppiumDemoProject\\TestData\\ValidUserDetails.xlsx";
        File file = new File(filepath);

        FileInputStream fis = new FileInputStream(file);       

        Workbook wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheetAt(0);

        String data = sheet.getRow(row).getCell(cell).getStringCellValue();

        wb.close();
        
        return data;

    }
    
    
    public String[] ReadUserDetails(int row) throws Exception {

        String filepath = "C:\\Users\\A215776\\Workspace\\Mobile\\AppiumDemoProject\\TestData\\ValidUserDetails.xlsx";
        File file = new File(filepath);

        FileInputStream fis = new FileInputStream(file);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheetAt(0);
        String[] cellData = new String[2];
        for (int i=0; i<=1; i++)
        {
            //String data = sheet.getRow(row).getCell(i).getStringCellValue();
            cellData[i] = sheet.getRow(row).getCell(i).getStringCellValue().toString();                    
                    
        }  
        wb.close();        
        return cellData;

    }
}


//}
