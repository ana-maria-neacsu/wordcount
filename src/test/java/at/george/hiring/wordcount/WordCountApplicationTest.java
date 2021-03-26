package at.george.hiring.wordcount;

import at.george.hiring.wordcount.business.wordcount.WordCountData;
import at.george.hiring.wordcount.input.InputSource;
import at.george.hiring.wordcount.output.OutputSink;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountApplicationTest {

    @Test
    void GIVEN_aSentence_WHEN_countWords_THEN_returnWordCount() {
        TestInputSource testInputSource = new TestInputSource();
        TestOutputSink testOutputSink = new TestOutputSink();
        new WordCountApplication(testInputSource, testOutputSink, s -> new WordCountData(5, 5, BigDecimal.ONE, Collections.emptySet())).run(new String[0]);

        assertEquals(1, testInputSource.counterMethodInvocation);
        assertEquals(2, testOutputSink.counterMethodInvocation);
        assertEquals("Number of words: 5, unique: 5, average word length: 1,00", testOutputSink.lastMessage);
    }

    static class TestInputSource implements InputSource {

        int counterMethodInvocation = 0;

        @Override
        public String getText() {
            counterMethodInvocation++;
            return "Mary had a little lamb";
        }
    }

    static class TestOutputSink implements OutputSink {

        String lastMessage;
        int counterMethodInvocation = 0;

        @Override
        public void print(String logMessage) {
            counterMethodInvocation++;
            lastMessage = logMessage;
        }
    }

}