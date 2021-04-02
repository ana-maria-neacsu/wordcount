package wordcount.Pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		this.stopWords = new ArrayList<String>();
		this.setText(text);
	}

	public WordCount(String text, String stopWordsFileName) {
		this.listOfWords = new ArrayList<String>();
		this.setText(text);

		textReader = new TextReader(stopWordsFileName);
		this.stopWords = textReader.read();
	}

	public CountWordsDTO count() {
		
		
		List<String> validWords = listOfWords.stream()
				.filter((word) -> word.matches(ONLY_LETTERS_REGEX) && !stopWords.contains(word))
				.collect(Collectors.toList());
		
		long countValidWords = validWords.stream().count();

		long countDuplicatedWords = listOfWords.stream()
				.filter((word) -> listOfWords.contains(word))
				.count();
		
		Map<String, Long> counts = validWords.stream()
				   .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

		long countUniqueWords = countValidWords - countDuplicatedWords;

		CountWordsDTO countWordsDTO = new CountWordsDTO(countValidWords, countUniqueWords);

		return countWordsDTO;
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
	}

	@Override
	public void setText(ArrayList<String> words) {
		this.listOfWords = words;
	}

	@Override
	public void setText(ArrayList<String> words, String stopWordsFileName) {
		this.listOfWords = words;
		textReader = new TextReader(stopWordsFileName);
		this.stopWords = textReader.read();
	}

	private void splitTextWords() {
		text = text.replace(". ", " ");
		text = text.replace("-", " ");
		text = text.replace(".", "");
		
		String[] wordsArray = text.split(" ");
		List<String> arrayOfWords = Arrays.asList(wordsArray);
		this.listOfWords.addAll(arrayOfWords);
	}

}
