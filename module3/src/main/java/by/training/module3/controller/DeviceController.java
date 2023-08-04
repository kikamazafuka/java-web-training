package by.training.module3.controller;

import by.training.module3.command.Command;
import by.training.module3.command.CommandException;
import by.training.module3.command.CommandProvider;
import by.training.module3.command.CommandType;
import by.training.module3.entity.Device;
import by.training.module3.service.DeviceService;
import by.training.module3.validator.FileValidator;
import by.training.module3.validator.ValidationResult;
import by.training.module3.validator.XMLValidator;
import org.apache.log4j.Logger;

import java.util.List;

public class DeviceController {
    private Logger LOGGER = Logger.getLogger(DeviceController.class);

    private FileValidator fileValidator;
    private XMLValidator xmlValidator;
    private CommandProvider<Device> commandProvider;
    private DeviceService deviceService;

    public DeviceController(FileValidator fileValidator,
                            XMLValidator xmlValidator,
                            CommandProvider<Device> commandProvider,
                            DeviceService deviceService) {
        this.fileValidator = fileValidator;
        this.xmlValidator = xmlValidator;
        this.commandProvider = commandProvider;
        this.deviceService = deviceService;
    }

    public void readFile(String xmlPath,String xsdPath, CommandType commandType) {
        ValidationResult xmlFileValidationResult = fileValidator.validateFile(xmlPath);

        if (!xmlFileValidationResult.isValid()) {
            LOGGER.error("File " + xmlPath + " is not valid");
            return;
        }
        ValidationResult xsdFileValidationResult = xmlValidator.validateAgainstXSD(xmlPath);

        if (!xsdFileValidationResult.isValid()) {
            LOGGER.error("File " + xmlPath + " is not valid");
            return;
        }

        try {
            Command command = commandProvider.getCommand(commandType);
            List<Device> deviceList = command.build(xmlPath);
            deviceList.forEach(entity -> deviceService.create(entity ));
        } catch (CommandException e) {
            LOGGER.error(e);
        }
    }
}
