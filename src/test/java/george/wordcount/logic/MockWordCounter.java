package george.wordcount.logic;

import org.junit.jupiter.api.Assertions;

public class MockWordCounter implements WordCounter {
    private final String expectedInput;
    private final int returnValue;

    public MockWordCounter(String expectedInput, int returnValue) {
        this.expectedInput = expectedInput;
        this.returnValue = returnValue;
    }

    @Override
    public int countWordsOf(String input) {
        Assertions.assertEquals(this.expectedInput, input);

        return this.returnValue;
    }
}
