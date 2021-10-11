package model;

import junit.framework.TestCase;
import org.junit.Before;

public class CarShowroomTest extends TestCase {
    public CarShowroom carShowroom = new CarShowroom();

    public void setUp() throws Exception {
        super.setUp();
        carShowroom.addCar(new Car("BMW","blue"));
        carShowroom.addCar(new Car("AUDI","blue"));
        carShowroom.addCar(new Car("FORD","blue"));
        carShowroom.addCar(new Car("SKODA","blue"));

    }

    public void testSortUp() {
        carShowroom.sortUp();
        CarShowroom carShowroomTest = new CarShowroom();
        carShowroomTest.addCar(new Car("AUDI","blue"));
        carShowroomTest.addCar(new Car("BMW","blue"));
        carShowroomTest.addCar(new Car("FORD","blue"));
        carShowroomTest.addCar(new Car("SKODA","blue"));
        for(int i = 0 ; i < carShowroomTest.getCars().size(); i++) {
            assertEquals(carShowroomTest.getCars().get(i).getModel(), carShowroom.getCars().get(i).getModel());
        }
    }

    public void testSortDown() {
        carShowroom.sortDown();
        CarShowroom carShowroomTest = new CarShowroom();
        carShowroomTest.addCar(new Car("SKODA","blue"));
        carShowroomTest.addCar(new Car("FORD","blue"));
        carShowroomTest.addCar(new Car("BMW","blue"));
        carShowroomTest.addCar(new Car("AUDI","blue"));
        for(int i = 0 ; i < carShowroomTest.getCars().size(); i++) {
            assertEquals(carShowroomTest.getCars().get(i).getModel(), carShowroom.getCars().get(i).getModel());
        }
    }
}