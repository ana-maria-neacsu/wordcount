package wordcount.tests;

import org.junit.jupiter.api.Test;

import wordcount.Pojo.CountWordsDTO;
import wordcount.Pojo.ITextReader;
import wordcount.Pojo.TextReader;
import wordcount.Pojo.WordCount;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class WordCountTests {

	@Test
	public void simpleCountWords() {
	
		long expectedCount = 5;
		String text = "Mary had a little lamb";
		WordCount wordCount = new WordCount(text);
		
		CountWordsDTO countWordsDTO = wordCount.count();
		
		assertTrue(countWordsDTO.getCountTotalWords() == expectedCount);
	}
	
	
	@Test
	public void countWordsWithSpecialCharacters() {
	
		long expectedCount = 2;
		String text = "Mary had 3little lamb$";
		WordCount wordCount = new WordCount(text);
		
		CountWordsDTO countWordsDTO = wordCount.count();
		
		assertTrue(countWordsDTO.getCountTotalWords() == expectedCount);
	}
	
	@Test
	public void countWordsWithoutStopWords() {
	
		long expectedCount = 4;
		String stopWordsFileName = "src/test/resources/testStopWords.txt";
		String text = "Mary had a little lamb";
		WordCount wordCount = new WordCount(text, stopWordsFileName);
		CountWordsDTO countWordsDTO = wordCount.count();
		
		assertTrue(countWordsDTO.getCountTotalWords() == expectedCount);
	}
	
	
	@Test
	public void countWordsFromTextFile() {
	
		long expectedCount = 4;
		String stopWordsFileName = "src/test/resources/testStopWords.txt";
		String inputFile = "src/test/resources/testInput.txt";
		
		WordCount wordCount = new WordCount();
		ITextReader textReader = new TextReader(inputFile);
		
		ArrayList<String> words = textReader.read();
		wordCount.setText(words, stopWordsFileName);
		
		CountWordsDTO countWordsDTO = wordCount.count();
		
		assertTrue(countWordsDTO.getCountTotalWords() == expectedCount);
	}
	
	
	@Test
	public void countUniqueWordsFromText() {
	
		String stopWordsFileName = "src/test/resources/testStopWords.txt";

		String text = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
		WordCount wordCount = new WordCount(text, stopWordsFileName);
		
		CountWordsDTO countWordsDTO = wordCount.count();
		
		assertTrue(countWordsDTO.getCountTotalWords() > countWordsDTO.getCountUniqueWords());
	}
	
	
}