package at.erste.words.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class InputReaderFromFile implements InputReader {

    String wordsFileName;

    public InputReaderFromFile(String wordsFileName) {
        //TODO check if file exists otherwise do not even create instance
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
            System.err.println(wordsFileName + "file does not exists. Exiting");
            System.exit(1);
        }
        return words.toString();
    }

}
