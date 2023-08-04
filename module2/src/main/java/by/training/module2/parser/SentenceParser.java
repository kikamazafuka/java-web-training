package by.training.module2.parser;

import by.training.module2.composite.TextLeaf;
import by.training.module2.model.WordLeaf;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends TextParser{
    private static final Logger LOGGER = Logger.getLogger(SentenceParser.class);
    private final static String SENTENCE_REGEX = "([A-Z])(.)+?(\\.)";


    @Override
    public List<TextLeaf> parseText(String text) {

        LOGGER.info("parseText Sentence Method");

        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);

        List<TextLeaf> result = new ArrayList<>();
        while (matcher.find()) {
            TextLeaf sentences = new WordLeaf(matcher.group(2), matcher.group(1), matcher.group(3));
            result.add(sentences);
        }
         if (next != null) {
            next.parseText(text);
        }
        LOGGER.info("List size: " + result.size());
        return result;
    }
}
