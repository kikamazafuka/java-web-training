package by.training.module2.service;

import by.training.module2.composite.TextLeaf;
import by.training.module2.model.WordLeaf;
import by.training.module2.repository.WordLeafRepository;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class WordLeafService {

    private static final Logger LOGGER = Logger.getLogger(WordLeafService.class);

    private WordLeafRepository words;

    public WordLeafService(WordLeafRepository words) {
        LOGGER.info("WordLeafService constructor");
        this.words = words;
    }

    public void addWords(WordLeaf tour){
        this.words.add(tour);
    }

    public List<TextLeaf> getWords(){
        return this.words.getAll();
    }

    public List<TextLeaf> sortBy(Comparator<TextLeaf> comparator){
        List<TextLeaf> sortedWords = words.getAll();
        sortedWords.sort(comparator);
        return sortedWords;
    }
}
