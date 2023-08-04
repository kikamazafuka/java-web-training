package by.training.module2.parser;

import by.training.module2.composite.TextLeaf;

import java.util.List;

public abstract class TextParser implements ParseChain{

    TextParser next;
    public void setNext(TextParser next) {
        this.next = next;
    }
    public abstract List<TextLeaf> parseText(String text);
}
