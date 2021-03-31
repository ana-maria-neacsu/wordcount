package george.wordcount.libraries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

class StopWordProviderTest {
    @Test
    public void GIVEN_instance_WHEN_provide_called_THEN_stop_words_from_file_retrieved() throws URISyntaxException, IOException {
        // GIVEN:
        final StopWordProvider classUnderTest = new StopWordProvider();

        // WHEN:
        final List<String> result = classUnderTest.provide();

        // THEN:
        Assertions.assertEquals(result, Arrays.asList("the",
                "a",
                "on",
                "off"));
    }
}