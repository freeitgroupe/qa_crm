import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class MyFirstProgram {
    //private double paramTemp;

    public static void main(String[] args) {
        String filePath = "E:\\GIT\\qa_crm\\sandbox\\src\\main\\java\\altek.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // обновляем значения
            updateElementValue(doc);

            // добавляем новый элемент
            //addElement(doc);

            // запишем отредактированный элемент в файл
            // или выведем в консоль
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("E:\\GIT\\qa_crm\\sandbox\\src\\main\\java\\altek1.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML успешно изменен!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // добавили элемент paradigm
    private static void addElement(Document doc) {
        NodeList languages = doc.getElementsByTagName("offer");
        Element lang = null;
        //проходим по каждому элементу Language
        for(int i=0; i<languages.getLength(); i++){
            lang = (Element) languages.item(i);
            Element paradigmElement = doc.createElement("paradigm");
            paradigmElement.appendChild(doc.createTextNode("oop"));
            lang.appendChild(paradigmElement);
        }
    }

    // изменяем значение существующего элемента name
    private static void updateElementValue(Document doc) {
        NodeList languages = doc.getElementsByTagName("offer");
        Element lang = null;
        // проходим по каждому элементу Language
        for(int i=0; i<languages.getLength();i++){
            lang = (Element) languages.item(i);
            Node name = lang.getElementsByTagName("price").item(0).getFirstChild();
            String paramTemp = String.valueOf(Double.parseDouble(name.getNodeValue()));
            float price = Float.parseFloat(paramTemp.trim());
            float price2 = (float) (28.2 * price);
            name.setNodeValue(String.valueOf(price2));
        }
    }

}
