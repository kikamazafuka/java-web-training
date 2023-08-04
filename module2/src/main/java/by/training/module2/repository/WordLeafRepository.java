package by.training.module2.repository;

import by.training.module2.composite.TextLeaf;
import by.training.module2.controller.TextController;
import by.training.module2.model.WordLeaf;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordLeafRepository implements Repository <TextLeaf>{

    private static final Logger LOGGER = Logger.getLogger(TextController.class);

    private List<TextLeaf> wordLeafList;

    public WordLeafRepository() {
        LOGGER.info("WordLeafRepository constructor");
        this.wordLeafList = new LinkedList<>();
    }


    @Override
    public void add(TextLeaf item) {

        wordLeafList.add(item);
    }

    @Override
    public void remove(TextLeaf item) {

        wordLeafList.remove(item);
    }

    @Override
    public List<TextLeaf> getAll() {
        return this.wordLeafList;
    }

    @Override
    public List<TextLeaf> findBy(Specification<TextLeaf> spec) {

        List<TextLeaf> found = new ArrayList<>();

        for (TextLeaf word : this.wordLeafList) {
            if (spec.isSatisfiedBy(word)) {
                found.add(word);
            }
        }
        return found;
    }
}
