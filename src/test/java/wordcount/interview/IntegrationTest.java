package wordcount.interview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcount.interview.mock.PrintStreamMock;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private static final String EXPECTED_ENTER_TEXT = "Enter text:";
    private static final String EXPECTED_NUMBER_OF_WORDS = "Number of words: ";
    private static final String WORD = "Word";
    private static final int EXPECTED_COUNT = 1;
    private PrintStreamMock out;

    @BeforeEach
    void setUp() {
        out = new PrintStreamMock(System.out);
        ByteArrayInputStream in = new ByteArrayInputStream(WORD.getBytes());
        System.setOut(out);
        System.setIn(in);
    }

    @Test
    void shouldHaveTwoOutputText() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(2, outputTexts.size());
    }

    @Test
    void shouldAskFirstForEnterText() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(EXPECTED_ENTER_TEXT, outputTexts.get(0));
    }

    @Test
    void shouldOneCountWordAndPutItToOutput() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(EXPECTED_NUMBER_OF_WORDS + EXPECTED_COUNT, outputTexts.get(1));
    }

}
