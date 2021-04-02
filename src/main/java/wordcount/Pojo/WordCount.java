package wordcount.Pojo;

import java.util.ArrayList;
import java.util.Arrays;

public class WordCount implements IWordCount {

	private String text;
	private ArrayList<String> listOfWords;
	private static final String ONLY_LETTERS_REGEX = "^[a-zA-Z]+$";
	private ITextReader textReader;
	private ArrayList<String> stopWords;
	
	public WordCount() {
		this.stopWords = new ArrayList<String>();
		this.listOfWords = new ArrayList<String>();
	}
	
	public WordCount(String text) {
		this.listOfWords = new ArrayList<String>();
		this.setText(text);
	}
	
	public WordCount(String text, String stopWordsFileName) {
		this.listOfWords = new ArrayList<String>();
		this.setText(text);
		
		textReader = new TextReader(stopWordsFileName);
		this.stopWords = textReader.read();
	}
	
	
	public long count() {
		long countValidWords = listOfWords.stream()
				  .filter((word) -> word.matches(ONLY_LETTERS_REGEX)
						  && !stopWords.contains(word))
				  .count();
		
		return countValidWords;
	}
	
	public void setStopWordsReader(String fileName) {
		textReader = new TextReader(fileName);
		this.stopWords = textReader.read();
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		splitTextWords();
		this.stopWords = new ArrayList<String>();
	}
	
	@Override
	public void setText(ArrayList<String> words) {
		this.listOfWords = words;
		this.stopWords = new ArrayList<String>();
	}
	
	@Override
	public void setText(ArrayList<String> words, String stopWordsFileName) {
		this.listOfWords = words;
		textReader = new TextReader(stopWordsFileName);
		this.stopWords = textReader.read();
	}
	
	private void splitTextWords() {
		this.listOfWords.addAll(Arrays.asList(text.split(" ")));
	}
	
}
