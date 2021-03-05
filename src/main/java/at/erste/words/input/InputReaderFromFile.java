package at.erste.words.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class InputReaderFromFile implements InputReader {

    String wordsFileName;

    public InputReaderFromFile(final String wordsFileName) {
        checkFileExists(wordsFileName);
        this.wordsFileName = wordsFileName;
    }

    public String getInput() {
        ClassLoader classLoader = getClass().getClassLoader();
        File wordsFile = new File(classLoader.getResource(wordsFileName).getFile());

        StringBuilder words = new StringBuilder();

        try (Scanner sc = new Scanner(wordsFile)) {
            while (sc.hasNextLine()) {
                words.append(sc.nextLine());
                words.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(wordsFileName + "file does not exists");
        }
        return words.toString();
    }

    private void checkFileExists(String wordsFileName) {
        if (getClass().getClassLoader().getResource(wordsFileName) == null) {
            throw new IllegalArgumentException(wordsFileName + "file does not exists");
        }
    }

}
