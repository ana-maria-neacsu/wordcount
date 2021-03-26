package at.george.hiring.wordcount.input;

import java.util.Scanner;

public class ConsoleInputSourceImpl implements InputSource {
    @Override
    public String getText() {
        try (Scanner input = new Scanner(System.in)) {
            return input.nextLine();
        }
    }
}
