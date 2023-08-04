package by.training.module2.model;

public enum TextPartFunction {
    PARAGRAPH( "Paragraph" , 1 ),
    SENTENCE( "Sentence" , 2 ),
    WORD( "Word" , 3 );

    private final int level;
    private final String title;

    TextPartFunction( String title, int level) {
        this .title = title;
        this .level = level;
    }

    public int getLevel() {
        return this .level;
    }

    public String getTitle() {
        return title;
    }
}
