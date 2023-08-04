package by.training.module3.command;

import by.training.module3.entity.Device;
import by.training.module3.parser.Parser;
import by.training.module3.parser.ParserException;
import by.training.module3.parser.StAXDeviceParser;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class StAXParserCommand implements Command<Device> {
    private Parser<Device> parser = new StAXDeviceParser();

    @Override
    public List<Device> build(String path) throws CommandException {
        try {
            return parser.parse(path);
        } catch (ParserException | XMLStreamException | FileNotFoundException e) {
            throw new CommandException();
        }
    }
}
