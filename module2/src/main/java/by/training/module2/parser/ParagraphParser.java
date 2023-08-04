package by.training.module2.parser;

import by.training.module2.composite.TextLeaf;
import by.training.module2.model.WordLeaf;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends TextParser{
    private static final Logger LOGGER = Logger.getLogger(ParagraphParser.class);
    private final static String PARAGRAPH_REGEX = "(\\t)(.+)(\\n+)?";


    @Override
    public List<TextLeaf> parseText(String text) {

        LOGGER.info("parseText Paragraph Method");

        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(text);

        List<TextLeaf> result = new ArrayList<>();
        while (matcher.find()) {
            TextLeaf paragraph = new WordLeaf(matcher.group(2), matcher.group(1), matcher.group(3));
            result.add(paragraph);
        }
        if (next != null) {
            next.parseText(text);
        }
        return result;

    }
}
