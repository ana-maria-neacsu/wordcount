package wordcount.tests;

import org.junit.jupiter.api.Test;

import george.WordCount.Interfaces.ITextReader;
import wordcount.Pojo.TextReader;

import static org.junit.jupiter.api.Assertions.*;

public class TextReaderTests {

	
	@Test
	public void textReaderCanRead() {
		
		String fileName = "src/test/resources/testStopWords.txt";
		ITextReader reader = new TextReader(fileName);
		
		assertTrue(reader.read().size() > 0);
		
	}
	
}
