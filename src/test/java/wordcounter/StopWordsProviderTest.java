package wordcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wordcounter.exceptions.StopWordsProviderException;

public class StopWordsProviderTest {

    @Test
    public void should_throw_exception_when_unable_to_find_the_file() {
        Assertions.assertThrows(StopWordsProviderException.class, () -> provideNonExistingFilename());
    }

    private void provideNonExistingFilename() {
        StopWordsProvider stopWordsProvider = new StopWordsProvider("asfds");
        stopWordsProvider.getStopWords();
    }

}
