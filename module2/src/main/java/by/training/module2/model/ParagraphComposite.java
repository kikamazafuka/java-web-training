package by.training.module2.model;

import by.training.module2.composite.TextComposite;
import by.training.module2.composite.TextLeaf;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ParagraphComposite implements TextComposite {

    private static final Logger LOGGER = Logger.getLogger(ParagraphComposite.class);
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private List<TextLeaf> sentences;
    private int id;

    public ParagraphComposite() {
        this.sentences = new LinkedList<>();
        this.id = COUNTER.getAndIncrement();
    }

    @Override
    public void addText(TextLeaf text) {
        sentences.add(text);

    }

    @Override
    public String getText() {

        LOGGER.info("Paragraph getText method");

        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        for (TextLeaf sentence : this.sentences){
            sb.append(sentence.getText());
        }
        return sb.toString();
    }

    public long getId() {
        LOGGER.info("Get ID: "+ id);
        return id;
    }

}
