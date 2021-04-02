package george.WordCount;

import java.util.ArrayList;

import george.WordCount.Interfaces.*;
import wordcount.Pojo.CountWordsDTO;
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
		
		System.out.println("Please enter a filename: ");
		String fileName = inputReader.readLine();
		
		if(!fileName.isEmpty()){
			textReader = new TextReader(fileName);
			ArrayList<String> words = textReader.read();
			wordCount.setText(words);
		}else {
			System.out.println("Please enter a text: ");
			String text = inputReader.readLine();
		    wordCount.setStopWordsReader(STOP_WORDS_FILENAME);
	        wordCount.setText(text);
		}

		CountWordsDTO countWordsDTO = wordCount.count();
	    System.out.println("Count of words without stop words: " +  countWordsDTO.getTotalWordsCount());
	    
	    System.out.println("Count of words: " +  countWordsDTO.getTotalWordsCount() + ", unique: " + countWordsDTO.getUniqueWordsCount());
	}
	
}