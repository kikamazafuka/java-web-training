package by.training.module3.parser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public interface Parser<T> {
    List<T> parse(String path) throws ParserException, XMLStreamException, FileNotFoundException;
}
