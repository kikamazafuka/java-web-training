package by.training.module3.validator;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



@RunWith(JUnit4.class)
public class XMLValidatorTest {


    private Logger LOGGER = Logger.getLogger(XMLValidator.class);

    private final String XML_PATH = "Device.xml";
    private final String INVALID_XML_PATH = "Invalid_Device.xml";
    private final String XSD_PATH = "Device.xsd";

    private ClassLoader classLoader = getClass().getClassLoader();
    /*
     Problem with getting files

    String xsdPath = new File(classLoader.getResource(XSD_PATH).getFile()).getAbsolutePath();
    String xmlPath = new File(classLoader.getResource(XML_PATH).getFile()).getAbsolutePath();
    String invalidXmlPath = new File(classLoader.getResource(INVALID_XML_PATH).getFile()).getAbsolutePath();
*/

    @Test
    public void validateAgainstXSD() {
        ValidationResult validationResult = new ValidationResult();
        XMLValidator validator = new XMLValidator(XSD_PATH);
        ValidationResult xmlValidate = validator.validateAgainstXSD(XML_PATH);
        LOGGER.info("Result of validation XML file " + XML_PATH + ": " + xmlValidate.isValid());

        Assert.assertEquals(validationResult.isValid(), xmlValidate.isValid());
    }

    @Test
    public void validateAgainstXSDInvalid() {
        XMLValidator validator = new XMLValidator(XSD_PATH);
        ValidationResult xmlValidate = validator.validateAgainstXSD(INVALID_XML_PATH);
        LOGGER.info("Result of validation XML file " + XML_PATH + ": " + xmlValidate.isValid());

        Assert.assertEquals(false, xmlValidate.isValid());
    }
}