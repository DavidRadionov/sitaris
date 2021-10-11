import model.CarShowroom;

import java.util.ArrayList;

public class FileXmlStruct {

    // вроде реализовал паттерн одиночки

    private String nameCity = "";
    private ArrayList<CarShowroom> carShowrooms;
    private static FileXmlStruct file = null;

    public String getNameCity() {
        return nameCity;
    }

    public ArrayList<CarShowroom> getCarShowrooms() {
        return carShowrooms;
    }

    private FileXmlStruct(String nameCity, ArrayList<CarShowroom> carShowrooms) {
        this.nameCity = nameCity;
        this.carShowrooms = carShowrooms;

    }

    public static FileXmlStruct createFileXmlStruct(String nameCity, ArrayList<CarShowroom> carShowrooms) {
        if(file==null) {
           file = new FileXmlStruct(nameCity, carShowrooms);
           return file;
        }  else {
            return file;
        }

    }
}
