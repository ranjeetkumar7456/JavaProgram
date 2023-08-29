package ExcelFile;

import java.util.ArrayList;

public class ReadExcel {
    public static void main(String[] args) {
        ExcelUtility ex= new ExcelUtility();
        String path="D://SELENIUM_FRAMEWORK//MavenProjects//SeleniumMaven//src//test//java//ExcelFile//TestData.xlsx";
        String excelName="TestData.xlsx";
        ArrayList<String> data =ex.getData(path,"test",0);
        for(String str: data)
        {
            System.out.println(str);
        }

    }
}
