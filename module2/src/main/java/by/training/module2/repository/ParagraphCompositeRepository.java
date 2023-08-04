package by.training.module2.repository;

import by.training.module2.model.ParagraphComposite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParagraphCompositeRepository implements Repository<ParagraphComposite> {
    private List<ParagraphComposite> wordLeafList;

    public ParagraphCompositeRepository() {
        this.wordLeafList = new LinkedList<>();
    }


    @Override
    public void add(ParagraphComposite item) {

        wordLeafList.add(item);
    }

    @Override
    public void remove(ParagraphComposite item) {

        wordLeafList.remove(item);
    }

    @Override
    public List<ParagraphComposite> getAll() {
        return wordLeafList;
    }

    @Override
    public List<ParagraphComposite> findBy(Specification<ParagraphComposite> spec) {

        List<ParagraphComposite> found = new ArrayList<>();

        for (ParagraphComposite paragraph: this.wordLeafList) {
            if (spec.isSatisfiedBy(paragraph)) {
                found.add(paragraph);
            }
        }
        return found;
    }
}
