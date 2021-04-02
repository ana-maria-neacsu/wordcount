package wordcount.tests;

import org.junit.jupiter.api.Test;

import wordcount.Pojo.ITextReader;
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
