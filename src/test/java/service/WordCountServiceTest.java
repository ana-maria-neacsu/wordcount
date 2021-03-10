package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCountServiceTest {

    WordCountService wordCountService = new WordCountService();

    public List<String> initializeStopWords(){
        return Arrays.asList("the","a","on","off");
    }

    @Test
    public void countWordEmptyTextTest() {
        Assertions.assertEquals(0, wordCountService.countWords("",initializeStopWords()));
    }

    @Test
    public void countWordWithNumbersTest() {
        Assertions.assertEquals(1, wordCountService.countWords("word 123",initializeStopWords()));
    }

    @Test
    public void countWordTest() {
        Assertions.assertEquals(2, wordCountService.countWords("word count",initializeStopWords()));
    }

    @Test
    public void countWordWithSpecialCharacterTest() {
        Assertions.assertEquals(0, wordCountService.countWords("word, \"",initializeStopWords()));
    }

    @Test
    public void countWordWithNonEnglishAlphabet(){
        Assertions.assertEquals(1, wordCountService.countWords("test خسام",initializeStopWords()));
    }

    @Test
    public void countWordRequirement(){
        Assertions.assertEquals(4, wordCountService.countWords("Mary had a little lamb",initializeStopWords()));
    }

    @Test
    public void countWordWithNoStopWord(){
        Assertions.assertEquals(5, wordCountService.countWords("Mary had a little lamb",
                new ArrayList<String>()));
    }

    @Test
    public void countWordOnlyStopWords(){
        Assertions.assertEquals(0, wordCountService.countWords("a on off test",
                Arrays.asList("on","off","a","test")));
    }

    @Test
    public void countWordWithDifferentCases(){
        Assertions.assertEquals(2, wordCountService.countWords("A on oFF test",
                Arrays.asList("on","off","a","oFF")));
    }
}
