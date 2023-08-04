package by.training.module3.command;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public interface Command<T> {
    List<T> build (String path) throws CommandException;
}
