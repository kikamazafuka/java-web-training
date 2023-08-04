package by.training.module2.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public String getData(String path) {
        LOGGER.info("get Data ");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            LOGGER.info("Reading file "+path);
            for (String line : lines) {
                LOGGER.info(line);
            }
        } catch (IOException e) {
            LOGGER.error("File not found "+e);
        }
        return String.join("\n",lines);
    }
}
