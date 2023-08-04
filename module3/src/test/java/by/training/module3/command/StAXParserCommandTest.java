package by.training.module3.command;

import by.training.module3.entity.Device;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class StAXParserCommandTest {

    private Logger LOGGER = Logger.getLogger(DomParserCommandTest.class);

    private final String XML_PATH = "Device.xml";
    private final String INVALID_XML_PATH = "Invalid_Device.xml";
    private final String XSD_PATH = "Device.xsd";

    private ClassLoader classLoader = getClass().getClassLoader();

    //Problem with getting files

    //String xsdPath = new File(classLoader.getResource(XSD_PATH).getFile()).getAbsolutePath();
    //String xmlPath = new File(classLoader.getResource(XML_PATH).getFile()).getAbsolutePath();
    // String invalidXmlPath = new File(classLoader.getResource(INVALID_XML_PATH).getFile()).getAbsolutePath();

    @Test
    public void build() throws CommandException {
        List<Device> deviceList = new StAXParserCommand().build(XML_PATH);
        Assert.assertEquals(16,deviceList.size());
    }
}