import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WordCounterITest {

    private final AbstractSentenceSplitter testObject;
    private final String sentence;
    private final int expectedWordsCount;

    public WordCounterITest(final String sentence, final int expectedWordsCount) {
        this.testObject = new SentenceSplitterI();
        this.sentence = sentence;
        this.expectedWordsCount = expectedWordsCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        // given
        return Arrays.asList(new Object[][]{
                {"word", 1},
                {"word word", 2},
                {"wo2rd", 2},
                {"", 0},
                {"word Word", 2},
                {null, 0}
        });
    }

    @Test
    public void should_count_words() {
        // when
        final WordCounterResult actualCount = testObject.split(sentence);

        // then
        assertEquals(expectedWordsCount, actualCount.getCount());
    }

}