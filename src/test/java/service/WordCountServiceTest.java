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
    public void countWordRequirementTest(){
        Assertions.assertEquals(4, wordCountService.countWords("Mary had a little lamb",initializeStopWords()));
    }

    @Test
    public void countWordWithNoStopWordTest(){
        Assertions.assertEquals(5, wordCountService.countWords("Mary had a little lamb",
                new ArrayList<String>()));
    }

    @Test
    public void countWordOnlyStopWordsTest(){
        Assertions.assertEquals(0, wordCountService.countWords("a on off test",
                Arrays.asList("on","off","a","test")));
    }

    @Test
    public void countWordWithDifferentCasesTest(){
        Assertions.assertEquals(2, wordCountService.countWords("A on oFF test",
                Arrays.asList("on","off","a","oFF")));
    }

    @Test
    public void countUniqueWordsRequirementTest(){
        Assertions.assertEquals(7, wordCountService.countUniqueWords(
                "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",
                Arrays.asList("on","off","a","the")));
    }

    @Test
    public void countWordsRequirementTest(){
        Assertions.assertEquals(9, wordCountService.countUniqueWords(
                "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.",
                Arrays.asList("on","off","a","the")));
    }

    @Test
    public void countUniqueWordsCaseSensitiveTest(){
        Assertions.assertEquals(7, wordCountService.countUniqueWords(
                "THE quick brown fox jumps over the lazy Brown fox",
                Arrays.asList("THE","the")));
    }

    @Test
    public void countUniqueWordsAllRepeatedTest(){
        Assertions.assertEquals(1, wordCountService.countUniqueWords(
                "word word word word",
                Arrays.asList()));
    }

}
