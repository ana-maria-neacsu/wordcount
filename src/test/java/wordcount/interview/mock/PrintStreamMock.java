package wordcount.interview.mock;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PrintStreamMock extends PrintStream {
    private List<String> outputTexts;

    public PrintStreamMock(OutputStream out) {
        super(out);
        this.outputTexts = new ArrayList<>();
    }

    @Override
    public void println(String text) {
        outputTexts.add(text);
    }

    public List<String> getOutputTexts() {
        return outputTexts;
    }
}
