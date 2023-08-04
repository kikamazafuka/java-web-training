package by.training.module3.command;

import by.training.module3.entity.Device;
import by.training.module3.parser.Parser;
import by.training.module3.parser.ParserException;
import by.training.module3.parser.SAXDeviceParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class SAXParserCommand implements Command<Device> {

    private Parser<Device> parser = new SAXDeviceParser();

    @Override
    public List<Device> build(String path) throws CommandException {

        try {
            return parser.parse(path);
        } catch (ParserException | XMLStreamException | FileNotFoundException e) {
            throw new CommandException();
        }
    }
}
