package by.training.module2.service;

import by.training.module2.composite.TextLeaf;

import java.util.Comparator;

public class WordComparator implements Comparator<TextLeaf> {

    @Override
    public int compare(TextLeaf o1, TextLeaf o2) {
        return Integer.compare(o1.getText().length(),o2.getText().length());
    }


}
