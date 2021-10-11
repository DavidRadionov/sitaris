import model.CarShowroom;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void writeFile(Parser parser) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        File htmlTemplateFile = new File("/Users/davidradionov/Desktop/sitaris/src/main/resources/output.html");
        FileUtils.writeStringToFile(htmlTemplateFile, parser);
    }
    public static void main(String[] argc) throws IOException, SAXException, ParserConfigurationException, TransformerException {

        Parser parser = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите вариант парсинга: 1.Dom, 2.SAX");
        int choice = 0;
        String input = in.next();
        if(input.matches("[1-2]{1}")) {
            choice = Integer.parseInt(input);
        } else {
            System.out.println("Ввели значения не верно");
            return;
        }

        switch (choice) {
            case 1:
                parser = new ParserDOM();
                break;
            case 2:
                parser = new ParserSAX();
                break;
            default:
                System.out.println("Ввели значения не верно");
        }

        if(parser != null) {
            parser.parsing();
            if(parser.file != null) {
                System.out.println("Файл успешно был спарсен с помощью " + parser.name);
                boolean next = true;
                while(next) {
                    System.out.println("Выберите действие:");
                    System.out.println("1.Посмотреть обработанный файл");
                    System.out.println("2.Отсортировать модели машин по алфавиту");
                    System.out.println("3.Отсортировать модели машин по алфавиту в обратную сторону");
                    System.out.println("0.Выход");
                    input = in.next();
                    if(input.matches("[0-3]{1}")) {
                        choice = Integer.parseInt(input);

                        switch (choice) {
                            case 1:

                                System.out.println("-Город: " + parser.file.getNameCity());
                                parser.file.getCarShowrooms().forEach(carShowroom -> {
                                    System.out.println("--Автосолон: " + carShowroom.getName());
                                    carShowroom.getCars().forEach(car -> {
                                        System.out.println("---Model: " + car.getModel());
                                        System.out.println("---Color: " + car.getColor());
                                    });
                                });
                                break;
                            case 2:
                                parser.file.getCarShowrooms().forEach(carShowroom -> {
                                    carShowroom.sortUp();

                                });
                                System.out.println("Oooo done -_^");
                                break;
                            case 3:
                                parser.file.getCarShowrooms().forEach(carShowroom -> {
                                    carShowroom.sortDown();

                                });
                                System.out.println("Oooo done -_^");
                                break;
                            case 0:
                                writeFile(parser);
                                next = false;
                                break;
                            default:
                                System.out.println("Ввели что-то не так, попробуйте еще раз");
                        }
                    } else {
                        System.out.println("Ввели значения не верно");
                    }
                }
            }
        }

    }
}