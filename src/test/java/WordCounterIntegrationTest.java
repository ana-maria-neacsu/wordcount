import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import wordcounter.InputProvider;
import wordcounter.OutputConsole;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterIntegrationTest {

    @Test
    public void testWordCounting() {
        //given
        InputProvider inputProvider = new TestableInputProvider("Hello, honey. I am home");
        TestableOutputConsole outputConsole = new TestableOutputConsole();

        //when
        WordCounterApp wordCounterApp = new WordCounterApp(inputProvider, outputConsole, emptySet());
        wordCounterApp.process();

        //then
        assertEquals("Enter text: ", getQuestionTextFromConsole(outputConsole));
        assertEquals("Number of words: 3", getResultTextFromConsole(outputConsole));
    }

    @Test
    public void testWordCountingWithStopWords() {
        //given
        InputProvider inputProvider = new TestableInputProvider("Hello, honey. I am home");
        TestableOutputConsole outputConsole = new TestableOutputConsole();
        Set<String> stopWords = new HashSet<>(asList("I", "am"));

        //when
        WordCounterApp wordCounterApp = new WordCounterApp(inputProvider, outputConsole, stopWords);
        wordCounterApp.process();

        //then
        assertEquals("Enter text: ", getQuestionTextFromConsole(outputConsole));
        assertEquals("Number of words: 1", getResultTextFromConsole(outputConsole));
    }

    private String getResultTextFromConsole(TestableOutputConsole outputConsole) {
        //result text is the second line printed in the console
        return outputConsole.getLinesPrinted().get(1);
    }

    private String getQuestionTextFromConsole(TestableOutputConsole outputConsole) {
        //question is the first line printed in the console
        return outputConsole.getLinesPrinted().get(0);
    }

    private static class TestableInputProvider extends InputProvider {

        private final String inputText;

        public TestableInputProvider(String inputText) {
            this.inputText = inputText;
        }

        @Override
        public String getInput() {
            return inputText;
        }
    }

    private static class TestableOutputConsole extends OutputConsole {

        private List<String> linesPrinted = new ArrayList<>();

        @Override
        public void printLine(String text) {
            linesPrinted.add(text);
        }

        public List<String> getLinesPrinted() {
            return linesPrinted;
        }
    }
}
