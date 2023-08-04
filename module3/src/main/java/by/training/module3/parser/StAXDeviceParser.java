package by.training.module3.parser;

import by.training.module3.entity.*;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StAXDeviceParser implements Parser<Device>{

    private Device device;
    private DeviceType deviceType;
    private Logger LOGGER = Logger.getLogger(StAXDeviceParser.class);

    @Override
    public List<Device> parse(String path) throws ParserException, XMLStreamException, FileNotFoundException {
        LOGGER.info("parse method start...");
        List<Device> deviceList = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        File file = new File(path);
        XMLEventReader eventReader =
                factory.createXMLEventReader(new FileReader(file));
        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                if (startElement.getName().getLocalPart().equals("device")) {
                    device = new Device();
                    Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                    if (idAttr != null) {
                        device.setId(Integer.parseInt(idAttr.getValue()));
                    }
                    Attribute criticalAttr = startElement.getAttributeByName(new QName("critical"));
                    if (criticalAttr != null) {
                        device.setCritical(criticalAttr.getValue());
                    }
                }
                if (startElement.getName().getLocalPart().equals("name")) {
                    event = eventReader.nextEvent();
                    device.setName(event.asCharacters().getData());
                }
                if (startElement.getName().getLocalPart().equals("origin")) {
                    event = eventReader.nextEvent();
                    device.setOrigin(event.asCharacters().getData());
                }
                if (startElement.getName().getLocalPart().equals("price")) {
                    Price price = new Price();
                    Attribute currAttr = startElement.getAttributeByName(new QName("currency"));
                    if (currAttr != null) {
                        price.setCurrency(currAttr.getValue());
                    }
                    event = eventReader.nextEvent();
                    price.setValue(Integer.parseInt(event.asCharacters().getData()));
                    if (device != null) {
                        device.setPrice(price);
                    }
                }
                if (startElement.getName().getLocalPart().equals("cooling")) {
                    event = eventReader.nextEvent();
                    deviceType.setCooling(event.asCharacters().getData());
                }
                if (startElement.getName().getLocalPart().equals("group")) {
                    event = eventReader.nextEvent();
                    deviceType.setGroup(event.asCharacters().getData());
                }
                if (startElement.getName().getLocalPart().equals("power")) {
                    DevicePowerConsumption power = new DevicePowerConsumption();
                    Attribute powAttr = startElement.getAttributeByName(new QName("unit"));
                    if (powAttr != null) {
                        power.setUnit(powAttr.getValue());
                    }
                    event = eventReader.nextEvent();
                    power.setValue(Integer.parseInt(event.asCharacters().getData()));
                    deviceType.setDevicePowerConsumption(power);
                }
                if (startElement.getName().getLocalPart().equals("port")) {
                    event = eventReader.nextEvent();
                    deviceType.setPort(PortType.valueOf(event.asCharacters().getData()));
                }
                if (startElement.getName().getLocalPart().equals("type")) {
                    deviceType = new DeviceType();
                    device.setDeviceType(deviceType);
                }
            }
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equals("device")) {
                    deviceList.add(device);
                }
            }
        }
        for (Device dev : deviceList) {
            LOGGER.info("" + dev);
        }
        return deviceList;
    }


}
