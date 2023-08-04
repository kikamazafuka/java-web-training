package by.training.module2.repository;

import by.training.module2.model.SentenceComposite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SentenceCompositeRepository implements Repository <SentenceComposite> {
    private List<SentenceComposite> wordLeafList;

    public SentenceCompositeRepository() {
        this.wordLeafList = new LinkedList<>();
    }


    @Override
    public void add(SentenceComposite item) {

        wordLeafList.add(item);
    }

    @Override
    public void remove(SentenceComposite item) {

        wordLeafList.remove(item);
    }

    @Override
    public List<SentenceComposite> getAll() {
        return wordLeafList;
    }

    @Override
    public List<SentenceComposite> findBy(Specification<SentenceComposite> spec) {

        List<SentenceComposite> found = new ArrayList<>();

        for (SentenceComposite sentence : this.wordLeafList) {
            if (spec.isSatisfiedBy(sentence)) {
                found.add(sentence);
            }
        }
        return found;
    }
}
