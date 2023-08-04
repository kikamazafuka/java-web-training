package by.training.module3.parser;

import by.training.module3.entity.Device;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXDeviceParser implements Parser<Device>{

    private Logger LOGGER = Logger.getLogger(SAXHandler.class);


    private List<Device> deviceList = new ArrayList<>();

    @Override
    public List<Device> parse(String path) throws ParserException{
        File file = new File(path);
        String xml = file.getAbsolutePath();
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = parserFactor.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(xml, handler);
            deviceList = handler.getDeviceList();
            for (Device device : deviceList) {
                LOGGER.debug("" + device);
            }
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }  catch (SAXException | IOException e) {
            LOGGER.error(e);
            throw new ParserException(e);
        }
        return deviceList;
    }
}
