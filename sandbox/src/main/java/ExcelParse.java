import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.UUID;

// GET DATE & TIME IN ANY FORMAT

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

      DocumentBuilderFactory crunchifyDocBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder crunchifyDocBuilder;
      crunchifyDocBuilder = crunchifyDocBuilderFactory.newDocumentBuilder();
      Document crunchifyDoc = crunchifyDocBuilder.newDocument();
      Element mainRootCategories = crunchifyDoc.createElementNS("Excel parser", "yml_catalog");
      crunchifyDoc.appendChild(mainRootCategories);
      String oldWord="";
      while (rowIterator.hasNext()){
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();//проходимся по строкам
        int rowCheckCategary = 0;

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
                //System.out.print(Math.round(cell.getNumericCellValue())+ "\t");
                myWriter.write(Math.round(cell.getNumericCellValue()) + "\t");
                break;
              }else{
                //System.out.printf("%.2f", cell.getNumericCellValue());
                myWriter.write(String.format("%.2f",cell.getNumericCellValue()) + "\t");
                break;
              }
            case STRING:
              if(rowIndex1 == 0){
                if (cell.getStringCellValue().indexOf('.') > 0){
                  String firstWord = cell.getStringCellValue().replaceAll(" *", "");
                  //UUID.randomUUID().toString()
                  if(oldWord != ""){
                    String firstWord1 = firstWord.replaceAll("[.].*", "");
                    if(firstWord1 == oldWord){
                      String parentCat = oldWord;
                    }
                  }
                  String newIdCat = "1" +i;
                  mainRootCategories.appendChild(getCategory(crunchifyDoc,  newIdCat, cell.getStringCellValue(), firstWord ) ) ;

                  oldWord = firstWord;
                  rowCheckCategary = 1;
                  break;
                };

              }else{
                //System.out.print(cell.getStringCellValue() + " \t");
                myWriter.write(cell.getStringCellValue() + "\t");
                break;
              }
            case FORMULA:
              break;
          }
         }

        if( rowCheckCategary == 0){
         //System.out.println();
          myWriter.write("\n");
        }
        i++;

        //if(i == 5000){

        //}

      }
      file.close();
      myWriter.close();

      Transformer crunchifyTransformer = TransformerFactory.newInstance().newTransformer();
      crunchifyTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(crunchifyDoc);
      //StreamResult console = new StreamResult(System.out);
      //crunchifyTransformer.transform(source, console);
      StreamResult result = new StreamResult(new File("ScoreDetail.xml"));
      crunchifyTransformer.transform(source, result);
      return;



    }catch(Exception e){
      System.out.println("Что то пошло не так");
    }

    // Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
    DocumentBuilderFactory crunchifyDocBuilderFactory = DocumentBuilderFactory.newInstance();

    // Defines the API to obtain DOM Document instances from an XML document.
    DocumentBuilder crunchifyDocBuilder;
    try {
      crunchifyDocBuilder = crunchifyDocBuilderFactory.newDocumentBuilder();

      // The Document interface represents the entire HTML or XML document.
      Document crunchifyDoc = crunchifyDocBuilder.newDocument();

      // The Element interface represents an element in an HTML or XML document.
      Element mainRootElement = crunchifyDoc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Companies");
      Element mainRootCategories = crunchifyDoc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Categories");
      Element mainRootOffers = crunchifyDoc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Offers");
      Element mainRootOffer = crunchifyDoc.createElementNS("", "Offer");

      // Adds the node newChild to the end of the list of children of this node.
      // If the newChild is already in the tree, it is first removed.
      crunchifyDoc.appendChild(mainRootCategories);

      // append child elements to root element
      mainRootCategories.appendChild(getCompany(crunchifyDoc, "1", "Paypal", "Payment", "1000"));
      mainRootCategories.appendChild(getCompany(crunchifyDoc, "2", "Amazon", "Shopping", "2000"));

      // output DOM XML to console

      // An instance of this abstract class can transform a source tree into a result tree.
      Transformer crunchifyTransformer = TransformerFactory.newInstance().newTransformer();
      crunchifyTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

      // Acts as a holder for a transformation Source tree in the form of a Document Object Model (DOM) tree.
      DOMSource source = new DOMSource(crunchifyDoc);

      // Acts as an holder for a transformation result, which may be XML, plain Text, HTML, or some other form of markup.
      StreamResult console = new StreamResult(System.out);
      crunchifyTransformer.transform(source, console);
      System.out.println("\nTutorial by Crunchify. XML DOM Created Successfully..");

      //StreamResult result = new StreamResult(new File("/Users/myXml/ScoreDetail.xml"));
      //crunchifyTransformer.transform(source, result);
      //System.out.println("File saved!");

    } catch (TransformerException | ParserConfigurationException e) {
      e.printStackTrace();
    }

  }

  // The Node interface is the primary datatype for the entire Document Object Model.
  // It represents a single node in the document tree.
  private static Node getCompany(Document doc, String id, String name, String age, String role) {
    Element crunchifyCompany = doc.createElement("Company");
    crunchifyCompany.setAttribute("id", id);
    crunchifyCompany.appendChild(getCrunchifyCompanyElements(doc, crunchifyCompany, "Name", name));
    crunchifyCompany.appendChild(getCrunchifyCompanyElements(doc, crunchifyCompany, "Type", age));
    crunchifyCompany.appendChild(getCrunchifyCompanyElements(doc, crunchifyCompany, "Employees", role));
    return crunchifyCompany;
  }

  // Utility method to create text node
  private static Node getCrunchifyCompanyElements(Document doc, Element element, String name, String value) {
    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    return node;
  }


  private static Node getCategory(Document doc, String categoryId, String categoryName, String categoryParent) {
    Element crunchifyCat = doc.createElement("Category");
    crunchifyCat.setAttribute("categoryId", categoryId);
    crunchifyCat.setAttribute("categoryParent", categoryParent);
    crunchifyCat.appendChild(getCrunchifyCategoryElements(doc, crunchifyCat, "categoryName", categoryName));
    return crunchifyCat;
  }

  // Utility method to create text node
  private static Node getCrunchifyCategoryElements(Document doc, Element element, String name, String value) {
    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    return node;
  }


  /*
   <offer available="true" group_id="1557" id="2111138">
        <price>14212.8</price>
        <categoryId>4333491</categoryId>
        <name>Водонагреватель ALTEK ABD-B-0200 с двумя теплообменниками</name>
    </offer>
   */



}
