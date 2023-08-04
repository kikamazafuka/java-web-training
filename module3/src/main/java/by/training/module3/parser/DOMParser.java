package by.training.module3.parser;

import by.training.module3.entity.*;
import by.training.module3.validator.XMLValidator;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements Parser<Device>{
    private Logger LOGGER = Logger.getLogger(XMLValidator.class);

    @Override
    public List<Device> parse(String path) throws ParserException {
        LOGGER.info("parse method");
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;// = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException();
        }
        File file = new File(path);
        String xml = file.getAbsolutePath();
        Document document = null;
        try {
            document = builder.parse(xml);
        }  catch (SAXException | IOException e) {
            LOGGER.error(e);
            throw new ParserException(e);
        }
        List<Device> deviceList = new ArrayList<>();
        NodeList nodeList =
                document.getDocumentElement().getChildNodes();

        runOverElements(nodeList);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Device device = new Device();
                String id = node.getAttributes().
                        getNamedItem("id").getNodeValue();
                LOGGER.info("ID: " + id);
                device.setId(Integer.parseInt(id));
                String critical = node.getAttributes().
                        getNamedItem("critical").getNodeValue();
                LOGGER.info("Critical: " + critical);
                device.setCritical(critical);
                NodeList childNodes = node.getChildNodes();
                LOGGER.info("Child nodes length " + childNodes.getLength());
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element) {
                        LOGGER.info("cNode name: "+cNode.getNodeName());
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "name":
                                device.setName(content);
                                LOGGER.info("" + device.getName());
                                break;
                            case "origin":
                                device.setOrigin(content);
                                LOGGER.info("" + device.getOrigin());
                                break;
                            case "price":{
                                Price price = new Price();
                                String priceValueStr = cNode.getTextContent();
                                LOGGER.info("nodeValue " + priceValueStr);
                                price.setValue(Integer.parseInt(priceValueStr));
                                device.setPrice(price);
                                String priceCurrencyStr = ((Element) cNode).getAttribute("currency");
                                price.setCurrency(priceCurrencyStr);
                            }
                                LOGGER.info("" + device.getPrice());
                                break;
                            case "type": {
                                DeviceType deviceType = new DeviceType();
                                NodeList dTypeNodesList = cNode.getChildNodes();
                                LOGGER.info("dTypeNodeList " + dTypeNodesList.getLength());
                                for (int k = 0; k < dTypeNodesList.getLength(); k++) {
                                    Node dTypeNode = dTypeNodesList.item(k);
                                    if (dTypeNode instanceof Element) {
                                        LOGGER.info("dTypeNode name: "+dTypeNode.getNodeName());
                                        String dTypeContent = dTypeNode.getTextContent().trim();
                                        LOGGER.info("dTypeContent: "+dTypeContent);
                                        switch (dTypeNode.getNodeName()) {
                                            case "cooling":
                                                deviceType.setCooling(dTypeContent);
                                                break;
                                            case "group":
                                                deviceType.setGroup(dTypeContent);
                                                break;
                                            case "power":{
                                                DevicePowerConsumption powerConsumption = new DevicePowerConsumption();
                                                String powerStr = dTypeNode.getTextContent();
                                                System.out.println(powerStr);
                                                LOGGER.info("nodeValue " + powerStr);
                                                powerConsumption.setValue(Integer.parseInt(powerStr));
                                                LOGGER.info("power value "+powerConsumption.getValue());
                                                String priceCurrencyStr = ((Element) dTypeNode).getAttribute("unit");
                                                powerConsumption.setUnit(priceCurrencyStr);
                                                LOGGER.info("power unit "+powerConsumption.getUnit());
                                                LOGGER.info("power " + deviceType.getDevicePowerConsumption());
                                                 deviceType.setDevicePowerConsumption(powerConsumption);
                                                break;
                                            }
                                            case "port":
                                                String powerStr = dTypeNode.getTextContent();
                                                LOGGER.info("port cont "+powerStr);
                                                deviceType.setPort(PortType.valueOf(powerStr));
                                        }
                                    }
                                    device.setDeviceType(deviceType);
                                }

                            }
                            break;
                        }
                    }
                }
                deviceList.add(device);
            }
        }

        for (Device device : deviceList) {
            LOGGER.info(""+device);
        }
        return deviceList;
    }

    private void runOverElements(NodeList nodeList) {

        for (int ki = 0; ki < nodeList.getLength(); ki++) {
            if (nodeList.item(ki) instanceof Element) {
                System.out.println("Run over nodelist " + ki + " " + nodeList.item(ki).getNodeName());
                if (nodeList.item(ki).hasChildNodes()) {
                    runOverElements(nodeList.item(ki).getChildNodes());
                }
            }
        }
    }
}

