package wordcount.interview;

import org.junit.jupiter.api.Test;
import wordcount.interview.domain.WordCounter;
import wordcount.interview.ui.input.Input;
import wordcount.interview.ui.output.Output;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class WordCountTest {
    private static final String EMPTY = "";
    private static final String EXPECTED_ENTER_TEXT = "Enter text:";
    private static final String INPUT_TEXT = "inputText";
    private InputMock input;
    private OutputMock output;
    private WordCounterMock wordCounter;
    private WordCount sut;


    @Test
    void shouldWriteCorrectEnterTextLineToOutput() {
        createSut(EMPTY, 0l);

        sut.run();

        List<String> outputText = output.getOutputTexts();
        assertEquals(EXPECTED_ENTER_TEXT, outputText.get(0));
    }

    @Test
    void shouldCallWordCounterCountOnInputText() {
        createSut(INPUT_TEXT, 0);

        sut.run();

        String textToCount = wordCounter.getTextToCount();
        assertEquals(INPUT_TEXT, textToCount);
    }

    private void createSut(String inputText, long expectedCount) {
        input = new InputMock(inputText);
        output = new OutputMock();
        wordCounter = new WordCounterMock(expectedCount);
        sut = new WordCount(input, output, wordCounter);
    }

    private class InputMock implements Input {
        private final String inputText;

        private InputMock(String inputText) {
            this.inputText = inputText;
        }

        @Override
        public String read() {
            return inputText;
        }
    }

    private class OutputMock implements Output {
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

    private class WordCounterMock extends WordCounter {
        private final long expectedCount;
        private String textToCount;

        private WordCounterMock(long expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public long count(String text) {
            textToCount = text;
            return expectedCount;
        }

        public String getTextToCount() {
            return textToCount;
        }
    }
}