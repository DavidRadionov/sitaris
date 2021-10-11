import model.Car;
import model.CarShowroom;

import java.util.ArrayList;

public class ParserSAX extends Parser {

    @Override
    void parsing() {
        this.name = "SAX";
        ArrayList<CarShowroom> carShowrooms = new ArrayList<>();
        Car car = new Car();

    }

}
