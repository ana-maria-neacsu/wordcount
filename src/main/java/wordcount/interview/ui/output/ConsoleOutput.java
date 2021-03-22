package wordcount.interview.ui.output;

import java.io.PrintStream;

public class ConsoleOutput implements Output {
    private final PrintStream out;

    public ConsoleOutput(PrintStream out) {
        this.out = out;
    }

    @Override
    public void write(String text) {
        out.println(text);
    }
}
