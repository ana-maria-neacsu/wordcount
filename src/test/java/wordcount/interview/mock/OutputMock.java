package wordcount.interview.mock;

import wordcount.interview.ui.output.Output;

import java.util.ArrayList;
import java.util.List;

public class OutputMock implements Output {
    private List<String> outputTexts;

    public OutputMock() {
        outputTexts = new ArrayList<>();
    }

    @Override
    public void write(String text) {
        outputTexts.add(text);
    }

    public List<String> getOutputTexts() {
        return outputTexts;
    }
}
