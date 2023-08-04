package by.training.module2.controller;

import by.training.module2.composite.TextLeaf;
import by.training.module2.model.WordLeaf;
import by.training.module2.parser.ParseChain;
import by.training.module2.parser.TextParser;
import by.training.module2.reader.DataReader;
import by.training.module2.service.WordLeafService;
import by.training.module2.service.WordComparator;
import by.training.module2.validator.FileValidator;
import by.training.module2.validator.ValidationResult;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TextController {

    FileValidator fileValidator;
    DataReader dataReader;
    WordLeafService service;
    TextParser parseChain;


    private static final Logger LOGGER = Logger.getLogger(TextController.class);


    public TextController(WordLeafService service, TextParser parseChain) {
        LOGGER.info("TextController constructor");
        this.service = service;
        this.parseChain = parseChain;
    }

    public TextController(FileValidator fileValidator, DataReader dataReader, WordLeafService service, TextParser parseChain) {
        this.fileValidator = fileValidator;
        this.dataReader = dataReader;
        this.service = service;
        this.parseChain = parseChain;
    }

    public String readFile(String path) {
        ValidationResult vr = fileValidator.validateFile(path);

        if (!vr.isValid()) {
            LOGGER.error("File " + path + " is not valid");

        }

        String text = dataReader.getData(path);

        //parseChain.parseText(text);

        return text;
    }

    public List<TextLeaf> readData(String text) {
        List<TextLeaf> list = new LinkedList<>();
        list = parseChain.parseText(text);

        return list;
    }

    public List<TextLeaf> getData() {
        List<TextLeaf> list = this.service.getWords();
        LOGGER.info("Method getData: " + list);
        return list;
    }

    public List<TextLeaf> sortByWordLength() {
        Comparator<TextLeaf> comparator = new WordComparator();
        List<TextLeaf> list = this.service.sortBy(comparator);
        for (TextLeaf t : list) {
            LOGGER.info("Sorted by : " + t);
        }
        return list;
    }

    public void sortByWordLength(List<TextLeaf> list) {
        Comparator<TextLeaf> comparator = new WordComparator();
        list = this.service.sortBy(comparator);
        for (TextLeaf t : list) {
            LOGGER.info("Sorted by : " + t);
        }
    }
       // return list;
}
