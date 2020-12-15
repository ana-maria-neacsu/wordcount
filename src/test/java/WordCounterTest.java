import com.george.domain.WordCounter;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

    private WordCounter counter = new WordCounter();

    @Test
    public void shouldReturn0WhenNoWordIsInformed() {

        String word = "";
        long result = counter.count(word);

        Assert.assertEquals(0, result);

    }

    @Test
    public void shouldReturn5WhenFiveWordSentenceIsInformed() {

        String word = "Mary had a little lamb";
        long result = counter.count(word);

        Assert.assertEquals(5, result);

    }

    @Test
    public void shouldReturn4WhenFiveWordSentenceIsInformedButOneWordIsInvalid() {

        String word = "Mary had a little lamb*";
        long result = counter.count(word);

        Assert.assertEquals(4, result);

    }

}