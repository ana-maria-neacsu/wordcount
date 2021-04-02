package george.WordCount;

import java.util.ArrayList;

import george.WordCount.Interfaces.*;
import wordcount.Pojo.CountWordsDTO;
import wordcount.Pojo.InputReader;
import wordcount.Pojo.OutputWriter;
import wordcount.Pojo.TextReader;
import wordcount.Pojo.WordCount;

public class WordCountMain
{
	
	private static IWordCount wordCount;
	private static ITextReader textReader;
	private static IOutputWriter outputWriter;
	private static IInputReader inputReader;
	private static final String STOP_WORDS_FILENAME = "src/main/resources/stopWords.txt";
//	private static final String INPUT_FILE_FILENAME = "src/main/resources/textInput.txt";
	
	public static void main(String args[]) {
		
		wordCount = new WordCount();
		inputReader = new InputReader();
		outputWriter = new OutputWriter();
		
		System.out.println("Please enter a filename: ");
		String fileName = inputReader.readLine();
		
		if(!fileName.isEmpty()){
			textReader = new TextReader(fileName);
			ArrayList<String> words = textReader.read();
		    wordCount.setStopWordsReader(STOP_WORDS_FILENAME);
			wordCount.setText(words);
		}else {
			System.out.println("Please enter a text: ");
			String text = inputReader.readLine();
		    wordCount.setStopWordsReader(STOP_WORDS_FILENAME);
	        wordCount.setText(text);
		}

		CountWordsDTO countWordsDTO = wordCount.count();
		outputWriter.WriteLine("Count of words without stop words: " +  countWordsDTO.getTotalWordsCount());   
		outputWriter.WriteLine("Count of words: " +  countWordsDTO.getTotalWordsCount() + ","
				+ " unique: " + countWordsDTO.getUniqueWordsCount() + ", average word length: " + countWordsDTO.getAverageWordLength());
	}
	
}