package by.training.module3.parser;

import by.training.module3.entity.Device;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class StAXDeviceParserTest {
    private Logger LOGGER = Logger.getLogger(StAXDeviceParserTest.class);

    private final String XML_PATH = "Device.xml";
    private final String INVALID_XML_PATH = "Invalid_Device.xml";
    private final String XSD_PATH = "Device.xsd";

    private ClassLoader classLoader = getClass().getClassLoader();

    //Problem with getting files

    //String xsdPath = new File(classLoader.getResource(XSD_PATH).getFile()).getAbsolutePath();
    //String xmlPath = new File(classLoader.getResource(XML_PATH).getFile()).getAbsolutePath();
   // String invalidXmlPath = new File(classLoader.getResource(INVALID_XML_PATH).getFile()).getAbsolutePath();

    @Test
    public void parse() throws XMLStreamException, ParserException {
        StAXDeviceParser stAXDeviceParser = new StAXDeviceParser();
        List<Device> deviceList = new ArrayList<>();
        try {
            deviceList = stAXDeviceParser.parse(XML_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.info("deviceList " + deviceList.size());
        Assert.assertEquals(16,deviceList.size());
    }
}