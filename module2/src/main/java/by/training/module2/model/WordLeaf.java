package by.training.module2.model;

import by.training.module2.composite.TextLeaf;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class WordLeaf implements TextLeaf {
    private static final Logger LOGGER = Logger.getLogger(WordLeaf.class);
    private static final AtomicLong COUNTER = new AtomicLong(1);

    private String word;
    private String beginning;
    private String ending;
    private long id;

    public WordLeaf(String word, String beginning, String ending) {
        this.word = word;
        this.beginning = beginning;
        this.ending = ending;
        this.id=COUNTER.getAndIncrement();
    }

    @Override
    public String getText() {
        LOGGER.debug("getText WordLeaf");
        StringBuilder sb = new StringBuilder();
        if (beginning != null) {
            sb.append(beginning);
        }
        sb.append(word);
        if (ending != null) {
            sb.append(ending);
        }
        LOGGER.info("word get text: "+sb);
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordLeaf wordLeaf = (WordLeaf) o;
        return Objects.equals(word, wordLeaf.word) &&
                Objects.equals(beginning, wordLeaf.beginning) &&
                Objects.equals(ending, wordLeaf.ending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, beginning, ending);
    }

    @Override
    public String toString() {
        return "WordLeaf{" +
                ", beginning='" + beginning + '\'' +
                "word='" + word + '\'' +
                ", ending='" + ending + '\'' +
                '}';
    }

    public long getId() {
        LOGGER.info("Get ID: "+ id);
        return id;
    }


    /*Find word by its ID*/
    public String findById(int id){
        return "";
    }
}
