package by.training.module2.model;

import by.training.module2.composite.TextComposite;
import by.training.module2.composite.TextLeaf;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SentenceComposite implements TextComposite {

    private static final Logger LOGGER = Logger.getLogger(SentenceComposite.class);
    private static final AtomicLong COUNTER = new AtomicLong(1);

    private List<TextLeaf> words;
    private boolean newLine;
    private long id;

    public SentenceComposite() {
        this.words = new LinkedList<>();
        this.id = COUNTER.getAndIncrement();
    }

    public boolean isNewLine() {
        return newLine;
    }

    public void setNewLine(boolean newLine) {
        this.newLine = newLine;
    }

    @Override
    public void addText(TextLeaf text) {
        this.words.add(text);
    }


    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        if (isNewLine()){
            sb.append("\n");
        }
        for (TextLeaf word : words){
            sb.append(word.getText());
            sb.append(" ");
        }
        return sb.toString();
    }

    public long getId() {
        LOGGER.info("Get ID: "+ id);
        return id;
    }




}
