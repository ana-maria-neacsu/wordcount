package at.erste.words;

import java.util.Scanner;

public class StandardInputReader {

    public String getInput() {
        String input = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }
        }
        return input;
    }
}
