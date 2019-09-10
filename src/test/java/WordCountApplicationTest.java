import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class WordCountApplicationTest {
    private WordCounter counter;

    @Test
    public void callWithOnlyLettersContained() {

        String input = "Just letters inside";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(3, numberOfWords);
    }

    @Test
    public void callWithOnlyNumbers() {
        String input = "11 11 11";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(0, numberOfWords);
    }

    @Test
    public void callWithEmptyInput() {
        String input = "";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(0, numberOfWords);
    }

    @Test
    public void callWithOneWord() {
        String input = "JustOneWord";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(1, numberOfWords);
    }

    @Test
    public void callWithWordsContainsInvalidCharacters() {
        String input = "1nvalid character in sentence";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(3, numberOfWords);
    }

    @Test
    public void callWithOtherDelimiterContained(){
        String input = "1nvalid.character in sentence";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(2, numberOfWords);
    }

    @Test
    public void callWithInvalidCharacterAndNumbers(){
        String input = "$nvalid character11 in sentence";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(2, numberOfWords);
    }

    @Test
    public void callWithInputContainsInvalidWordListenInFile(){
        String input = "A character11 on sentence the";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(1, numberOfWords);
    }

    @Test
    public void stopwordsDoesntExists(){
        String[] invalidWords = FileUtils.readWordsFromFile("stringwords.txt");
        assertEquals(0,invalidWords.length);
    }
    @Test
    public void stopwordsExists(){
        String[] invalidWords = FileUtils.readWordsFromFile("stopwords.txt");
        assertEquals(4,invalidWords.length);
    }
    @Test
    public void getSentenceFromFile(){
        String filename = "mytext.txt";
        String input = FileUtils.getSentenceFromFile(filename);
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        assertEquals(4, numberOfWords);
    }

    @Test
    public void inputAsEveryWordAsUnique(){
        String input = "Every word is unique";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        assertEquals(4, numberOfWords);
        assertEquals(4, numberOfUniqueWords);
    }
    @Test
    public void inputContainingDuplicateWords(){
        String input = "Every word is unique but this is a duplicate word";
        counter = new WordCounter(input);
        int numberOfWords = counter.getWordsCountInText();
        int numberOfUniqueWords = counter.getUniqueWordsCountInText();
        assertEquals(9, numberOfWords);
        assertEquals(7, numberOfUniqueWords);
    }

    @Test
    public void testInputWithArgument(){
        String input  = WordCountApplication.getInput("mytext.txt");
        assertEquals("Mary had a little lamb", input);
    }

}