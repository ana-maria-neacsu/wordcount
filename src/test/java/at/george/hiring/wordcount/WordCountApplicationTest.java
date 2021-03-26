package at.george.hiring.wordcount;

import at.george.hiring.wordcount.input.InputSource;
import at.george.hiring.wordcount.output.OutputSink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountApplicationTest {

    @Test
    void GIVEN_aSentence_WHEN_countWords_THEN_returnWordCount() {
        TestInputSource testInputSource = new TestInputSource();
        TestOutputSink testOutputSink = new TestOutputSink();
        new WordCountApplication(testInputSource, testOutputSink, s -> 5).run();

        assertEquals(1, testInputSource.counterMethodInvocation);
        assertEquals(2, testOutputSink.counterMethodInvocation);
        assertEquals("Number of words: 5", testOutputSink.lastMessage);
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