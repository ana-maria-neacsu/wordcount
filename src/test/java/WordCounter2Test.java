
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WordCounter2Test {

    private final WordCounter testObject;
    private final String sentence;
    private final int expectedWordsCount;

    public WordCounter2Test(final String sentence, final int expectedWordsCount) {
        this.testObject = new WordCounter();
        this.sentence = sentence;
        this.expectedWordsCount = expectedWordsCount;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        // given
        return Arrays.asList(new Object[][]{
                {"Mary had a little lamb", 4},
                {"Mary had a little a lamb", 4},
                {"Mary had a little the lamb", 4},
                {"on off", 0},
                {"Mary had little lamb", 4},
                {"on off off on a the some", 1},
                {null, 0}
        });
    }

    @Test
    public void should_count_words() {
        // when
        final int actualCount = testObject.count2(sentence);

        // then
        assertEquals(expectedWordsCount, actualCount);
    }

}
