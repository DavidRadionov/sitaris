import model.Car;
import model.CarShowroom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

    public static void writeStringToFile(File newHtmlFile, Parser parser) throws ParserConfigurationException, IOException, SAXException, TransformerException {

        ArrayList<CarShowroom> carShowrooms = parser.file.getCarShowrooms();
        DocumentBuilderFactory dbf;
        DocumentBuilder db ;
        Document doc;

        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();

        doc = db.parse(new File("/Users/davidradionov/Desktop/sitaris/src/main/resources/output.html"));
        //doc = db.parse(newHtmlFile);
        NodeList carShowroomList = doc.getDocumentElement().getElementsByTagName("p");
        //NodeList carList = doc.getDocumentElement().getElementsByTagName("ol");
        NodeList modelList = doc.getDocumentElement().getElementsByTagName("li");
        NodeList colorList = doc.getDocumentElement().getElementsByTagName("ul");
        int q = 0;
        for(int i = 0 ; i < carShowrooms.size(); i++) {
            Element n = (Element) carShowroomList.item(i);
            n.setTextContent(carShowrooms.get(i).getName());
            int a = q;
            for(int j = 0; j < carShowrooms.get(i).getCars().size(); j++) {
                Element n1 = (Element) modelList.item(j + a);
                Element n2 = (Element) colorList.item(j + a);

                n1.setTextContent(carShowrooms.get(i).getCars().get(j).getModel());
                n2.setTextContent(carShowrooms.get(i).getCars().get(j).getColor());
                q++;

            }


        }
        // doc.getDocumentElement().getElementsByTagName("p").item(0).getAttributes().item(0)
//        for (int temp = 0; temp < carShowroomList.getLength(); temp++) {
//
//            NodeList nNode = (NodeList) carShowroomList.item(temp);
//            Element n = (Element) carShowroomList.item(temp);
//            //System.out.println("\ncarShowroom :" + n.getAttribute("name"));
//            n.setTextContent(carShowrooms.get(temp).getName());
//            for (int i = 0; i < nNode.getLength(); i++) {
//                Node node = nNode.item(i);
//
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//
//                    System.out.println("\nCurrent Element :" + node.getNodeName());
//                    Element eElement = (Element) node;
//                    Element e1Element = (Element) eElement.getElementsByTagName("li");
//                    Element e2Element = (Element) eElement.getElementsByTagName("ul");
//
//                    e1Element.setTextContent(carShowrooms.get(temp).getCars().get(i).getModel());
//                    e2Element.setTextContent(carShowrooms.get(temp).getCars().get(i).getColor());
////                    eElement.getElementsByTagName("li").item(0).setTextContent(carShowrooms.get(temp).getCars().get(i).getModel());
////                    eElement.getElementsByTagName("ul").item(0).setTextContent(carShowrooms.get(temp).getCars().get(i).getColor());
////
//
//                }
//            }
//        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("/Users/davidradionov/Desktop/sitaris/src/main/resources/output1.html"));
        Source input = new DOMSource(doc);

        transformer.transform(input, output);
        //System.out.println(doc.toString());


    }
}
