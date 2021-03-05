import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelParse {
  public static void main(String[] args) throws IOException {
    try{
      FileInputStream file = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\temp_files\\price_test.xlsx"));
      XSSFWorkbook workbook = new XSSFWorkbook(file);  //получаем доступ к файлу
      XSSFSheet sheet = workbook.getSheetAt(0);  //доступ к листу
      Iterator<Row> rowIterator = sheet.iterator();    //доступ к строкам
      FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
      int i = 0;
      FileWriter myWriter = new FileWriter("C:\\Users\\admin\\Desktop\\temp_files\\filename.txt");
      while (rowIterator.hasNext()){
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();//проходимся по строкам

        while (cellIterator.hasNext()){ //смотрим ячейки
           Cell cell = cellIterator.next();
           int rowIndex1 = cell.getColumnIndex();
           int rowIndex = cell.getRowIndex();

          //Check the cell type after eveluating formulae
          //If it is formula cell, it will be evaluated otherwise no change will happen
          Object res = evaluator.evaluateInCell(cell).getCellType();
          switch (evaluator.evaluateInCell(cell).getCellType())
          {
            case NUMERIC:
              if(rowIndex1 == 0){
                System.out.print(Math.round(cell.getNumericCellValue())+ "\t");
                myWriter.write(Math.round(cell.getNumericCellValue()) + "\t");
                break;
              }else{
                System.out.printf("%.2f", cell.getNumericCellValue());
                myWriter.write(String.format("%.2f",cell.getNumericCellValue()) + "\t");
                break;
              }
            case STRING:
              System.out.print(cell.getStringCellValue() + " \t");
              myWriter.write(cell.getStringCellValue()+ "\t");
              break;
            case FORMULA:
              break;
          }
         }
        myWriter.write("\r\n");
        System.out.println();
        i++;
        if(i == 100){
          file.close();
          myWriter.close();
          return;
        }
      }

    }catch(Exception e){
      System.out.println("Что то пошло не так");
    }
  }
}
