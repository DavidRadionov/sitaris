import model.Car;
import model.CarShowroom;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParserDOM extends Parser {


    @Override
    void parsing() throws ParserConfigurationException, IOException, SAXException {
        this.name = "DOM";
        ArrayList<CarShowroom> carShowrooms = new ArrayList<>();
        DocumentBuilderFactory dbf;
        DocumentBuilder db ;
        Document doc;

        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        doc = db.parse(new File("/Users/davidradionov/Desktop/sitaris/src/main/resources/cars.xml"));
        NodeList carShowroomList = doc.getDocumentElement().getElementsByTagName("carShowroom");

        for (int temp = 0; temp < carShowroomList.getLength(); temp++) {

            CarShowroom carShowroom = new CarShowroom();
            NodeList nNode = (NodeList) carShowroomList.item(temp);
            Element n = (Element) carShowroomList.item(temp);
            System.out.println("\ncarShowroom :" + n.getAttribute("name"));
            carShowroom.setName(n.getAttribute("name"));
            for (int i = 0; i < nNode.getLength(); i++) {
                Node node = nNode.item(i);
                Car car = new Car();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("\nCurrent Element :" + node.getNodeName());
                    Element eElement = (Element) node;
                    car.setModel(eElement.getElementsByTagName("model").item(0).getTextContent());
                    car.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
                    carShowroom.addCar(car);
                    System.out.println("model : "
                            + eElement.getElementsByTagName("model").item(0).getTextContent());
                    System.out.println("color : "
                            + eElement.getElementsByTagName("color").item(0).getTextContent());

                }
            }
            carShowrooms.add(carShowroom);
        }

        this.file = FileXmlStruct.createFileXmlStruct("minck", carShowrooms);

    }
}
