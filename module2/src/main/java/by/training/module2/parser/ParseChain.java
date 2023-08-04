package by.training.module2.parser;

import java.util.List;

public interface ParseChain<T> {

   List<T> parseText(String text);

}
