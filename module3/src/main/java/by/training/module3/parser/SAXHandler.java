package by.training.module3.parser;

import by.training.module3.entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class SAXHandler extends DefaultHandler {
    private List<Device> deviceList = new ArrayList<>();
    private Device device;
    private String content;
    private Price price;
    private DeviceType deviceType;
    private DevicePowerConsumption devicePowerConsumption;

    private Logger LOGGER = Logger.getLogger(SAXHandler.class);

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {
        LOGGER.debug("start element");
        switch (qName) {
            case "device":
                device = new Device();
                device.setId(Integer.parseInt(attributes.getValue("id")));
                device.setCritical(attributes.getValue("critical"));
                LOGGER.debug("start element device: " + device.isCritical() + " " + device.getId());
                break;
            case "price":
                price = new Price();
                price.setCurrency(attributes.getValue("currency"));
                LOGGER.debug("start Price:" + attributes.getValue("currency"));
                break;
            case "type":
                deviceType = new DeviceType();
                break;
            case "power":
                devicePowerConsumption = new DevicePowerConsumption();
                devicePowerConsumption.setUnit(attributes.getValue("unit"));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch (qName) {
            case "device":
                deviceList.add(device);
                break;
            case "origin":
                device.setOrigin(content);
                break;
            case "name":
                device.setName(content);
                break;
            case "price":
                price.setValue(Integer.parseInt(content));
                device.setPrice(price);
                break;
            case "cooling":
                deviceType.setCooling(content);
                break;
            case "group":
                deviceType.setGroup(content);
                break;
            case "power":
                devicePowerConsumption.setValue(Integer.parseInt(content));
                deviceType.setDevicePowerConsumption(devicePowerConsumption);
                break;
            case "port":
                deviceType.setPort(PortType.valueOf(content));
            case "type":
                device.setDeviceType(deviceType);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
        LOGGER.debug("characteer content " + content);
    }

    List<Device> getDeviceList() {
        return deviceList;
    }
}

