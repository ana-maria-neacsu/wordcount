package at.george.hiring.wordcount.business;

import at.george.hiring.wordcount.business.stopword.StopWordsClasspathLoaderImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopWordsClasspathLoaderImplTest {

    @Test
    void GIVEN_aStopwordsFile_WHEN_loadStopWords_THEN_returnListWithStopWords() throws URISyntaxException, IOException {
        List<String> expectedStopWords = Files
                .lines(Paths.get(getClass().getResource("/stopwords.txt").toURI()))
                .collect(Collectors.toList());
        List<String> actualStopWordsList = new StopWordsClasspathLoaderImpl().loadStopWords();
        assertEquals(expectedStopWords, actualStopWordsList );
    }

}