package wordcount.interview.domain;

import org.junit.jupiter.api.Test;
import wordcount.interview.mock.OutputMock;
import wordcount.interview.mock.WordCountDefaultMock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class WordCountWithAskTest {
    private static final String EXPECTED_ENTER_TEXT = "Enter text:";

    private OutputMock output;
    private WordCountDefaultMock wordCountDefault;

    @Test
    void shouldWriteCorrectEnterTextLineToOutput() {
        WordCountWithAsk sut = createSut();

        sut.run();

        List<String> outputText = output.getOutputTexts();
        assertEquals(EXPECTED_ENTER_TEXT, outputText.get(0));
    }

    @Test
    void shouldCallWordCountDefault() {
        WordCountWithAsk sut = createSut();

        sut.run();

        assertTrue(wordCountDefault.isRunCalled());
    }

    private WordCountWithAsk createSut() {
        output = new OutputMock();
        wordCountDefault = new WordCountDefaultMock();
        return new WordCountWithAsk(output, wordCountDefault);
    }
}