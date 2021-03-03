import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelParse {
  public static void main(String[] args) throws IOException {
    try{
      FileInputStream file = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\temp_files\\price_new1.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(file);//получаем доступ к файлу
      XSSFSheet sheet = workbook.getSheetAt(0);//доступ к листу
      Iterator<Row> rowIterator = sheet.iterator();//доступ к строкам
      int i = 0;
      while (rowIterator.hasNext()){
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();//проходимся по строкам

        while (cellIterator.hasNext()){ //смотрим ячейки
           Cell cell = cellIterator.next();
           switch (cell.getCellType()){
             case NUMERIC:
               System.out.printf("%.0f" + " \t", cell.getNumericCellValue());
               break;
             case STRING:
               System.out.print(cell.getStringCellValue() + "\t\t");
               break;
             case FORMULA:
               System.out.print(cell.getNumericCellValue()+ "\t\t");
               break;
           }
         }
        System.out.println();
        i++;
        if(i == 20){
          file.close();
          return;
        }
      }

    }catch(Exception e){
      System.out.println("Что то пошло не так");
    }


  }

}
