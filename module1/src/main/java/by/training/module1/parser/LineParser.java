package by.training.module1.parser;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class LineParser {
    private final static String PARAMETER_SEPARATOR = ",";
    private final static String KEY_VALUE_SEPARATOR = "=";
    private final static int KEY_INDEX = 0;
    private final static int VALUE_INDEX = 1;

    private static final Logger LOGGER = Logger.getLogger(LineParser.class);

    public Map<String,String> parseLine(String line){
        Map<String,String> result = new HashMap<>();
        String[] parameters = line.split(PARAMETER_SEPARATOR);
        for (String parameter : parameters){
            String key;
            try {
                key = parameter.split(KEY_VALUE_SEPARATOR)[KEY_INDEX];
            } catch (ArrayIndexOutOfBoundsException ex){
                continue;
            }
            if (key.equals("")){
                continue;
            }
            String value;
            try{
                value = parameter.split(KEY_VALUE_SEPARATOR)[VALUE_INDEX];
            } catch (ArrayIndexOutOfBoundsException ex){
                value = "";
            }
            result.put(key,value);
        }
        return result;
    }
}
