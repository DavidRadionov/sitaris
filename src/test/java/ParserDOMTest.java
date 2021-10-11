import junit.framework.TestCase;
import model.Car;
import model.CarShowroom;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class ParserDOMTest extends TestCase {
    ArrayList<CarShowroom> carShowrooms = new ArrayList<>();
    public void setUp() throws Exception {
        super.setUp();

        CarShowroom carShowroom = new CarShowroom();
        carShowroom.setName("Skoda");
        carShowroom.addCar(new Car("ACTAVIA2020", "yellow"));
        carShowroom.addCar(new Car("ACTAVIA2021", "BLACK"));
        carShowroom.addCar(new Car("RAPID2021", "WHITE"));
        carShowroom.addCar(new Car("KODIAQ2021", "GREEN"));
        carShowrooms.add(carShowroom);
        carShowroom = new CarShowroom();
        carShowroom.setName("MERCEDES");
        carShowroom.addCar(new Car("GLC", "yellow"));
        carShowroom.addCar(new Car("c200", "BLACK"));
        carShowroom.addCar(new Car("AMG", "WHITE"));
        carShowroom.addCar(new Car("MAYBACH", "GREEN"));
        carShowroom.addCar(new Car("BENZ c-class", "BLUE"));
        carShowrooms.add(carShowroom);
        carShowroom = new CarShowroom();
        carShowroom.setName("BMW");
        carShowroom.addCar(new Car("I8", "yellow"));
        carShowroom.addCar(new Car("e39", "BLACK"));
        carShowroom.addCar(new Car("x5", "WHITE"));
        carShowroom.addCar(new Car("m5", "GREEN"));
        carShowroom.addCar(new Car("x7", "BLUE"));
        carShowrooms.add(carShowroom);
    }

    public void testParsing() throws ParserConfigurationException, IOException, SAXException {
        ParserDOM parserDOM = new ParserDOM();
        parserDOM.parsing();
        for(int i = 0; i < carShowrooms.size(); i++) {
            for(int j = 0 ; j < carShowrooms.get(i).getCars().size(); j++) {
                assertEquals(carShowrooms.get(i).getCars().get(j).getModel(), parserDOM.file.getCarShowrooms().get(i).getCars().get(j).getModel());
            }
        }

    }
}