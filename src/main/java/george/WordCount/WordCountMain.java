package george.WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import wordcount.Pojo.IWordCount;
import wordcount.Pojo.WordCount;

public class WordCountMain
{
	
	private static IWordCount wordCount;

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
	        
	        System.out.println(wordCount.count());
		
	}
	
}