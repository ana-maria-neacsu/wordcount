package helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcount.helper.StopWordsLoader;

import java.util.Arrays;
import java.util.List;

public class StopWordsLoaderTest {


    final StopWordsLoader stopWordsLoader = new StopWordsLoader();

    private final List<String> stopWords = Arrays.asList("the", "a", "on", "off");

    @Test
    public void testLoader() {
        List<String> stopWords = stopWordsLoader.loadStopWordsFromClassPath();
        Assertions.assertNotNull(stopWords);
        Assertions.assertEquals(4, stopWords.size());
        stopWords.forEach(s ->
                Assertions.assertTrue(stopWords.contains(s))
         );
    }
}
