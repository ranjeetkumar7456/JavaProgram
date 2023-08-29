package ExcelFile;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {
    //int i,j=0;
    String filePath;
    String fullPath;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    FileInputStream fis=null;
    FileOutputStream fos=null;
    int rowCount=0;
    int columnCount=0;
    ArrayList<String> values= new ArrayList<>();

    public ArrayList<String> getData(String excelPath, String sheetName, int rowNumber)
    {
        //this.filePath=fileLocation;
        fullPath=excelPath;
        try
        {
            fis=new FileInputStream(fullPath);
            workbook= new XSSFWorkbook(fis);
            sheet=workbook.getSheet(sheetName);
            sheet.getLastRowNum();
            columnCount= sheet.getRow(0).getLastCellNum();
            for(int i=0;i<columnCount-1;i++)
            {
                String value = row.getCell(i).getStringCellValue();
                values.add(value);
                //System.out.println(value);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return values;
    }


}
