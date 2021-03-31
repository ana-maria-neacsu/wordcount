package george.wordcount.libraries;

import george.wordcount.ui.TextInputOutput;

import java.io.Console;

public class JavaConsoleInputOutput implements TextInputOutput {
    private final Console console;

    public JavaConsoleInputOutput(Console console) {
        this.console = console;
    }

    @Override
    public void printText(String text) {
        this.console.printf(text + System.lineSeparator());
    }

    @Override
    public String promptUser(String inputText) {
        return this.console.readLine(inputText);
    }
}
