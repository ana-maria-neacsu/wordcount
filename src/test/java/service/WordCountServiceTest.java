package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCountServiceTest {

    WordCountService wordCountService = new WordCountService();
    @ParameterizedTest
    @CsvSource({"word count,2", "123 count,1", "foo,1"})
    public void countWordsTest(String text, String expected){
        Assertions.assertEquals(Integer.parseInt(expected),wordCountService.countWords(text));
    }

}
