package at.erste.words.input;

import java.io.PrintStream;
import java.util.Scanner;

public class InputReaderFromStdIn implements InputReader {

    public InputReaderFromStdIn(PrintStream out) {
        out.print("Enter text: ");
    }

    @Override
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
