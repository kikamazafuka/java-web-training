package by.training.module2.composite;


import by.training.module2.model.ParagraphComposite;

import java.util.List;

public interface TextComposite extends TextLeaf {
    void addText(TextLeaf text);

}
