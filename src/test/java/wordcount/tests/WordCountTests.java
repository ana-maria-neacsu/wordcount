package wordcount.tests;

import org.junit.jupiter.api.Test;

import wordcount.Pojo.WordCount;

import static org.junit.jupiter.api.Assertions.*;

public class WordCountTests {

	@Test
	public void simpleCountWords() {
	
		long expectedCount = 5;
		String text = "Mary had a little lamb";
		WordCount wordCount = new WordCount(text);
		
		assertTrue(wordCount.count() == expectedCount);
	}
	
	
	@Test
	public void countWordsWithSpecialCharacters() {
	
		long expectedCount = 2;
		String text = "Mary had 3little lamb$";
		WordCount wordCount = new WordCount(text);
		
		assertTrue(wordCount.count() == expectedCount);
	}
	
	@Test
	public void countWordsWithoutStopWords() {
	
		long expectedCount = 4;
		String fileName = "src/test/resources/testStopWords.txt";
		String text = "Mary had a little lamb";
		WordCount wordCount = new WordCount(text, fileName);
		
		assertTrue(wordCount.count() == expectedCount);
	}
	
	
}