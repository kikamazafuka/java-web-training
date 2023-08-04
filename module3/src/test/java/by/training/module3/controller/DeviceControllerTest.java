package by.training.module3.controller;

import by.training.module3.command.*;
import by.training.module3.entity.Device;
import by.training.module3.repository.DeviceRepositoryImpl;
import by.training.module3.service.DeviceService;
import by.training.module3.validator.FileValidator;
import by.training.module3.validator.XMLValidator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;


@RunWith(JUnit4.class)
public class DeviceControllerTest {

    private DeviceRepositoryImpl repository = new DeviceRepositoryImpl();
    private DeviceService deviceService = new DeviceService(repository);
    private FileValidator fileValidator = new FileValidator();
    private XMLValidator xmlValidator;
    private CommandProvider<Device> commandProvider = new CommandProviderImpl();
    private DeviceController deviceController;


    private Logger LOGGER = Logger.getLogger(DeviceControllerTest.class);

    private final String XML_PATH = "Device.xml";
    private final String INVALID_XML_PATH = "Invalid_Device.xml";
    private final String XSD_PATH = "Device.xsd";

    private ClassLoader classLoader = getClass().getClassLoader();

    //Problem with getting files

    //String xsdPath = new File(classLoader.getResource(XSD_PATH).getFile()).getAbsolutePath();
    //String xmlPath = new File(classLoader.getResource(XML_PATH).getFile()).getAbsolutePath();
    // String invalidXmlPath = new File(classLoader.getResource(INVALID_XML_PATH).getFile()).getAbsolutePath();


    @Test
    public void controlWithDOM() {

        commandProvider.addCommand(CommandType.DOM, new DomParserCommand());
        xmlValidator = new XMLValidator(XSD_PATH);

        deviceController = new DeviceController(fileValidator, xmlValidator, commandProvider, deviceService);
        deviceController.readFile(XML_PATH, XSD_PATH, CommandType.DOM);
        List<Device> deviceList = deviceService.getAll();
        Assert.assertEquals(16, deviceList.size());
    }

    @Test
    public void controlWithSAX() {

        commandProvider.addCommand(CommandType.SAX, new SAXParserCommand());
        xmlValidator = new XMLValidator(XSD_PATH);

        deviceController = new DeviceController(fileValidator, xmlValidator, commandProvider, deviceService);
        deviceController.readFile(XML_PATH, XSD_PATH, CommandType.SAX);
        List<Device> deviceList = deviceService.getAll();
        Assert.assertEquals(16, deviceList.size());

    }

    @Test
    public void controlWithStAX() {

        commandProvider.addCommand(CommandType.STAX, new StAXParserCommand());
        xmlValidator = new XMLValidator(XSD_PATH);

        deviceController = new DeviceController(fileValidator, xmlValidator, commandProvider, deviceService);
        deviceController.readFile(XML_PATH, XSD_PATH, CommandType.STAX);
        List<Device> deviceList = deviceService.getAll();
        Assert.assertEquals(16, deviceList.size());

    }
}