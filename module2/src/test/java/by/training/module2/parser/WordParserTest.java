package by.training.module2.parser;

import by.training.module2.composite.TextLeaf;
import by.training.module2.controller.TextController;
import by.training.module2.reader.DataReader;
import by.training.module2.repository.WordLeafRepository;
import by.training.module2.service.WordComparator;
import by.training.module2.service.WordLeafService;
import by.training.module2.validator.FileValidator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class WordParserTest {

    private static final Logger LOGGER = Logger.getLogger(WordParserTest.class);


    private static final String TEXT = "\tIt has survived not only five centuries, but also the leap into electronic typesetting, " +
            "remaining essentially unchanged." +
            "It was popularised in the with the release of Letraset sheets containing Lorem Ipsum passages, " +
            "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\tIt is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. \n" +
            "\tThe point of using Ipsum is that it has a more-or-less normal distribution of letters, " +
            "as opposed to using 'Content here, content here', making it look like readable English.\n" +
            "\tIt is a established fact that a reader will be of a page when looking at its layout.\n" +
            "\tBye.\n";

    private static final String SENTENCE = "\tIt has survived not only five centuries, but also the leap into electronic typesetting, " +
            "remaining essentially unchanged." +
            "It was popularised in the with the release of Letraset sheets containing Lorem Ipsum passages, " +
            "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "\tIt is a long established fact that a reader will be distracted by " +
            "the readable content of a page when looking at its layout. \n" ;

    private static final String WORD = "\tIt has survived not only five centuries, but also the leap into electronic typesetting, " +
            "remaining essentially unchanged.";

    private TextController textController;


    @Test
    public void parseText() {

        TextParser paragraphParser1 = new ParagraphParser();
        TextParser sentenceParser1 = new SentenceParser();
        TextParser wordParser1 = new WordParser();

        paragraphParser1.setNext(sentenceParser1);
        sentenceParser1.setNext(wordParser1);

        List<TextLeaf> paragraphList = paragraphParser1.parseText(TEXT);
        List<TextLeaf> sentenceList = sentenceParser1.parseText(SENTENCE);
        List<TextLeaf> wordList = wordParser1.parseText(WORD);


        Assert.assertEquals(paragraphList.size(),5);
        Assert.assertEquals(sentenceList.size(),3);
        Assert.assertEquals(wordList.size(),17);


    }

    @Test
    public void ControllerWithFile (){
        WordLeafRepository wordLeafRepository = new WordLeafRepository();
        WordLeafService wordLeafService = new WordLeafService(wordLeafRepository);
        FileValidator fileValidator = new FileValidator();
        DataReader dataReader = new DataReader();

        TextParser paragraphParser1 = new ParagraphParser();
        TextParser sentenceParser1 = new SentenceParser();
        TextParser wordParser1 = new WordParser();

        paragraphParser1.setNext(sentenceParser1);
        sentenceParser1.setNext(wordParser1);


        textController = new TextController(fileValidator, dataReader, wordLeafService,wordParser1);
        String s = textController
                .readFile(this.getClass().getClassLoader().getResource("Text.txt").getPath().substring(1));

        List<TextLeaf> data1 = textController.readData(s);
        for(TextLeaf t : data1){
            LOGGER.info(t);
        }


        textController.sortByWordLength(data1);

        Comparator<TextLeaf> comparator = new WordComparator();
        data1.sort(comparator);
        for(TextLeaf t : data1){
            LOGGER.info(t);
        }

        Assert.assertEquals("a", data1.get(0).getText());

    }

    @Test
    public void ControllerStringParse (){
        WordLeafRepository wordLeafRepository = new WordLeafRepository();
        WordLeafService wordLeafService = new WordLeafService(wordLeafRepository);

        TextParser paragraphParser1 = new ParagraphParser();
        TextParser sentenceParser1 = new SentenceParser();
        TextParser wordParser1 = new WordParser();

        paragraphParser1.setNext(sentenceParser1);
        sentenceParser1.setNext(wordParser1);

        textController = new TextController(wordLeafService,wordParser1);
        List<TextLeaf> list=textController.readData(WORD);

        textController.sortByWordLength(list);
        LOGGER.debug("size after sort: "+list.size());
        Comparator<TextLeaf> comparator = new WordComparator();
        list.sort(comparator);
        for(TextLeaf t : list){
            LOGGER.info(t);
        }

        Assert.assertEquals("It", list.get(0).getText());

    }
}