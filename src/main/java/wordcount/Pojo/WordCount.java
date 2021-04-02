package wordcount.Pojo;

import java.util.stream.Stream;

public class WordCount {

	private String text;
	private String[] listOfWords;
	private static final String ONLY_LETTERS_REGEX = "^[a-zA-Z]+$";
	
	public WordCount(String text) {
		this.setText(text);
		splitTextWords();
	}
	
	public long count() {
		long countValidWords = Stream.of(listOfWords)
				  .filter((word) -> word.matches(ONLY_LETTERS_REGEX))
				  .count();
		
		return countValidWords;
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
