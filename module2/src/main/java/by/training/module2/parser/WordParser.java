package by.training.module2.parser;

import by.training.module2.composite.TextLeaf;
import by.training.module2.model.WordLeaf;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordParser extends TextParser{
    private static final Logger LOGGER = Logger.getLogger(WordParser.class);
    private final static String WORD_REGEX = "([\\'\\(]+)?(\\w+|[\\-])([\\.\\,\\'\\)\\:]+)?";



    @Override
    public List<TextLeaf> parseText(String text) {

        LOGGER.info("parseText Word Method");

        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(text);

        List<TextLeaf> result = new ArrayList<>();
        while (matcher.find()) {
            TextLeaf word = new WordLeaf(matcher.group(2), matcher.group(1), matcher.group(3));
            result.add(word);
        }
        if (next != null) {
            next.parseText(text);
        }
        LOGGER.info("List size: " + result.size());
        return result;
    }
}
