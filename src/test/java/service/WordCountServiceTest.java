package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCountServiceTest {

    WordCountService wordCountService = new WordCountService();

    @Test
    public void countWordEmptyTextTest() {
        Assertions.assertEquals(0, wordCountService.countWords(""));
    }

    @Test
    public void countWordWithNumbersTest() {
        Assertions.assertEquals(1, wordCountService.countWords("word 123"));
    }

    @Test
    public void countWordTest() {
        Assertions.assertEquals(2, wordCountService.countWords("word count"));
    }

    @Test
    public void countWordWithSpecialCharacterTest() {
        Assertions.assertEquals(0, wordCountService.countWords("word, \""));
    }

    @Test
    public void countWordWithNonEnglishAlphabet(){
        Assertions.assertEquals(1, wordCountService.countWords("test خسام"));
    }

    @Test
    public void countWordRequirement(){
        Assertions.assertEquals(5, wordCountService.countWords("Mary had a little lamb"));
    }

}
