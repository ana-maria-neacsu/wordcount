package at.george.hiring.wordcount.business;

import at.george.hiring.wordcount.business.stopword.StopWordsClasspathLoaderImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StopWordsClasspathLoaderImplTest {

    static List<String> expectedStopWords;

    @BeforeAll
    static void setupClass() throws IOException, URISyntaxException {
        expectedStopWords = Files
                .lines(Paths.get(StopWordsClasspathLoaderImplTest.class.getResource("/stopwords.txt").toURI()))
                .collect(Collectors.toList());
    }

    @Test
    void GIVEN_aStopwordsFile_WHEN_loadStopWords_THEN_returnListWithStopWords() throws URISyntaxException, IOException {
        StopWordsClasspathLoaderImpl stopWordsClasspathLoader = new StopWordsClasspathLoaderImpl();
        for (String expectedStopWord : expectedStopWords) {
            assertTrue(
                    stopWordsClasspathLoader.containsWord(expectedStopWord),
                    String.format("Word '%s' is missing in Stopwords!", expectedStopWord)
            );
        }
    }

}