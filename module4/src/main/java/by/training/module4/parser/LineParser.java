package by.training.module4.parser;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    private final static String PARAMETER_SEPARATOR = ",";
    private final static String KEY_VALUE_SEPARATOR = "=";
    private final static int KEY_INDEX = 0;
    private final static int VALUE_INDEX = 1;

    private static final Logger LOGGER = Logger.getLogger(LineParser.class);

    public Map<String, String> parseLine(String line) {
        LOGGER.info("File parsing...");
        Map<String, String> result = new HashMap<>();
        String[] parameters = line.split(PARAMETER_SEPARATOR);
        for (String parameter : parameters) {
            String key;
            try {
                key = parameter.split(KEY_VALUE_SEPARATOR)[KEY_INDEX];
                LOGGER.info("File parsing key " + key);
            } catch (ArrayIndexOutOfBoundsException ex) {
                continue;
            }
            if (key.equals("")) {
                continue;
            }
            String value;
            try {
                value = parameter.split(KEY_VALUE_SEPARATOR)[VALUE_INDEX];
                LOGGER.info("File parsing value " + value);
            } catch (ArrayIndexOutOfBoundsException ex) {
                value = "";
                LOGGER.error("File parsing exception");
            }
            result.put(key.trim(), value.trim());
            LOGGER.info("Map " + result.toString() + " " + " key: " + key + " value: " + result.get(key));
        }
        LOGGER.info("File parsing result isEmpty: " + result.isEmpty());
        return result;
    }
}