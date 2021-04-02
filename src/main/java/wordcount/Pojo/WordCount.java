package wordcount.Pojo;

import java.util.ArrayList;
import java.util.stream.Stream;

public class WordCount implements IWordCount {

	private String text;
	private String[] listOfWords;
	private static final String ONLY_LETTERS_REGEX = "^[a-zA-Z]+$";
	private ITextReader textReader;
	private ArrayList<String> stopWords;
	
	public WordCount() {
		this.stopWords = new ArrayList<String>();
	}
	
	public WordCount(String text) {
		this.setText(text);
		splitTextWords();
		this.stopWords = new ArrayList<String>();
	}
	
	public WordCount(String text, String fileName) {
		this.setText(text);
		splitTextWords();
		
		textReader = new TextReader(fileName);
		this.stopWords = textReader.read();
	}
	
	
	public long count() {
		long countValidWords = Stream.of(listOfWords)
				  .filter((word) -> word.matches(ONLY_LETTERS_REGEX)
						  && !stopWords.contains(word))
				  .count();
		
		return countValidWords;
	}
	
	public void setTextReader(String fileName) {
		textReader = new TextReader(fileName);
		this.stopWords = textReader.read();
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		splitTextWords();
	}
	
	private void splitTextWords() {
		this.listOfWords = text.split(" ");
	}
	
}
