package george.WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import wordcount.Pojo.IInputReader;
import wordcount.Pojo.ITextReader;
import wordcount.Pojo.IWordCount;
import wordcount.Pojo.InputReader;
import wordcount.Pojo.TextReader;
import wordcount.Pojo.WordCount;

public class WordCountMain
{
	
	private static IWordCount wordCount;
	private static ITextReader textReader;
	private static IInputReader inputReader;
	private static final String STOP_WORDS_FILENAME = "src/main/resources/stopWords.txt";
//	private static final String INPUT_FILE_FILENAME = "src/main/resources/textInput.txt";
	
	public static void main(String args[]) {
		

		wordCount = new WordCount();
		inputReader = new InputReader();
		
		String fileName = inputReader.readLine();
		
		if(!fileName.isEmpty()){
			
			textReader = new TextReader(fileName);
			ArrayList<String> words = textReader.read();
			wordCount.setText(words);
		}else {
			String text = inputReader.readLine();
	        wordCount.setText(text);
		}

	    System.out.println("Count of words without special characters: " +  wordCount.count());
	        
	    wordCount.setStopWordsReader(STOP_WORDS_FILENAME);
	    System.out.println("Count of words without stop words: " +  wordCount.count());
	    
		
	}
	
}