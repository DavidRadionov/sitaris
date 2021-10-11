import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class Parser {
    FileXmlStruct file;
    String name = "";
    // TODO: тута сделаю шаблонный метод

    abstract void parsing() throws IOException, ParserConfigurationException, SAXException;
}
