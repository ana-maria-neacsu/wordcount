package george.wordcount.libraries;

import george.wordcount.logic.WordCounter;
import george.wordcount.ui.UserInteractionFlow;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleUserInteractionFlow extends UserInteractionFlow {
    private final PrintStream outputStream;
    private final Scanner inputScanner;

    public ConsoleUserInteractionFlow(WordCounter wordCounter, PrintStream outputStream, InputStream inputStream) {
        super(wordCounter);
        this.outputStream = outputStream;
        this.inputScanner = new Scanner(inputStream);
    }

    @Override
    protected void printText(String text) {
        this.outputStream.println(text);
    }

    @Override
    protected String promptUserForString(String inputText) {
        this.outputStream.print(inputText);

        return this.inputScanner.nextLine();
    }
}
