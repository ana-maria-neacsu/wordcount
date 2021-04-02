package george.WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import wordcount.Pojo.IWordCount;
import wordcount.Pojo.WordCount;

public class WordCountMain
{
	
	private static IWordCount wordCount;
	private static final String STOP_WORDS_FILENAME = "src/test/resources/stopWords.txt";
	
	public static void main(String args[]) {
		

		wordCount = new WordCount();
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	  
	        try {
				String text = reader.readLine();

		        wordCount.setText(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        System.out.println("Count of words without special characters: " +  wordCount.count());
	        
	  //   wordCount.setTextReader(STOP_WORDS_FILENAME);
	    // System.out.println("Count of words without stop words: " +  wordCount.count());
	    
		
	}
	
}