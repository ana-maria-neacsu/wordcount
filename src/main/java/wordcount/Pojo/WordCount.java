package wordcount.Pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import george.WordCount.Interfaces.ITextReader;
import george.WordCount.Interfaces.IWordCount;

public class WordCount implements IWordCount {

	private String text;
	private ArrayList<String> listOfWords;
	private static final String ONLY_LETTERS_REGEX = "^[a-zA-Z\\-]+$";
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
				.filter((word) -> word.matches(ONLY_LETTERS_REGEX) && !this.stopWords.contains(word))
				.collect(Collectors.toList());

		long countValidWords = validWords.stream().count();

		Map<String, Long> countDuplicatedGroups = validWords.stream()
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		
		double countWordsLength = validWords.stream()
				.mapToDouble(w -> w.length())
				.sum();
		
		double averageWordLength =  countWordsLength / countValidWords;

		long countDuplicatedWords = countDuplicatedGroups.entrySet().stream()
				.filter(map -> map.getValue().intValue() > 1).count();

		CountWordsDTO countWordsDTO = new CountWordsDTO(countValidWords, countDuplicatedWords, averageWordLength);

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
		ArrayList<String> newWords = new ArrayList<String>();
		words.forEach((word) -> newWords.add(TextFilterExtension.FilterText(word)));
		this.listOfWords = newWords;
	}

	@Override
	public void setText(ArrayList<String> words, String stopWordsFileName) {	
		this.listOfWords = words;	
		words.forEach((word) -> word = TextFilterExtension.FilterText(word));
		textReader = new TextReader(stopWordsFileName);
		this.stopWords = textReader.read();
	}

	private void splitTextWords() {
		text = TextFilterExtension.FilterText(text);
		String[] wordsArray = text.split(" ");
		List<String> arrayOfWords = Arrays.asList(wordsArray);
		this.listOfWords.addAll(arrayOfWords);
	}

}
