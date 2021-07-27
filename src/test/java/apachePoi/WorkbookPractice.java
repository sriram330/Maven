package apachePoi;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WorkbookPractice {



    public static void main(String[] args) throws IOException {

        File src = new File("C:\\Users\\DELL\\Downloads\\PlaywrightJava-main\\TestNGPractice\\src\\Book1.xlsx");

        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

                        //Sheet index
        XSSFSheet sh = wb.getSheetAt(0);
//        System.out.println(sh);

        //prints data present in row-1 col -1
        String data = sh.getRow(1).getCell(1).getStringCellValue();
//        System.out.println(data);

        int rowValues = sh.getLastRowNum();
        System.out.println("total row count is " + rowValues);



        sh.getRow(0).createCell(2).setCellValue("Pass");
        sh.getRow(1).createCell(2).setCellValue("Pass");
        sh.getRow(2).createCell(2).setCellValue("Fail");

        FileOutputStream fos = new FileOutputStream(src);
        wb.write(fos);

        wb.close();

        //Prints data present in row[i] and column 0 (First column values)
        for (int i = 0; i <= rowValues; i++) {
            String totalRowData = sh.getRow(i).getCell(2).getStringCellValue();
            System.out.println(totalRowData);
        }

    }
}
