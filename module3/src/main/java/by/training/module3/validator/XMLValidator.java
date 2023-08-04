package by.training.module3.validator;

import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {

    private Logger LOGGER = Logger.getLogger(XMLValidator.class);
    private String xsdPath;

    public XMLValidator(String pathXsd) {
        this.xsdPath = pathXsd;
    }


    public ValidationResult validateAgainstXSD(String xmlPath) {
        ValidationResult vr = new ValidationResult();

        try {
            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlPath));
        } catch (Exception ex) {
            vr.addErrorMsg("XML Validation", "XML " + xmlPath + "against XSD validation error");
            LOGGER.error(ex);
        }
        return vr;
    }
}
