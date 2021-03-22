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
    private static final String WORD = "Word the";
    private static final int EXPECTED_COUNT = 1;
    private static final String INPUT_FILE_PATH = "src/test/resources/input.txt";
    private PrintStreamMock out;
    private String[] fileAsInput;

    @BeforeEach
    void setUp() {
        out = new PrintStreamMock(System.out);
        ByteArrayInputStream in = new ByteArrayInputStream(WORD.getBytes());
        System.setOut(out);
        System.setIn(in);
        fileAsInput = getFileAsInput();
    }

    @Test
    void shouldHaveTwoOutputTextToConsole() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(2, outputTexts.size());
    }

    @Test
    void shouldAskFirstForEnterTextToConsole() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(EXPECTED_ENTER_TEXT, outputTexts.get(0));
    }

    @Test
    void shouldOneCountWordAndPutItToOutputFromConsole() {
        Application.main(null);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(EXPECTED_NUMBER_OF_WORDS + EXPECTED_COUNT, outputTexts.get(1));
    }

    @Test
    void shouldHaveOneOutputTextToConsole() {
        Application.main(fileAsInput);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(1, outputTexts.size());
    }

    @Test
    void shouldOneCountWordAndPutItToOutputFromFile() {
        Application.main(fileAsInput);

        List<String> outputTexts = out.getOutputTexts();
        assertEquals(EXPECTED_NUMBER_OF_WORDS + EXPECTED_COUNT, outputTexts.get(0));
    }

    private String[] getFileAsInput() {
        String[] args = new String[1];
        args[0] = INPUT_FILE_PATH;
        return args;
    }
}
