package wordcount.interview.ui.input;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
