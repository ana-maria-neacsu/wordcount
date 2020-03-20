package iterations.iteration.wordcount.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iterations.iteration.wordcount.WordCount;
import iterations.iteration.wordcount.WordCountDictionary;
import iterations.iteration.wordcount.WordCountUnique;
import iterations.iteration.wordcount.io.FileTextResourceReader;
import iterations.iteration.wordcount.io.IConfigurationReader;
import iterations.iteration.wordcount.io.ITextResourceReader;
import iterations.iteration.wordcount.io.TextConfigurationReader;

public class WordCountMain {

	private DecimalFormat df2Places = new DecimalFormat("#.##");

	public static void main(String[] args) {
		WordCountMain app = new WordCountMain();
		app.parameters = SettingsParameters.parse(args);
		app.configurationReader = new TextConfigurationReader(new FileTextResourceReader(app.parameters.getStopWordsFileName()));
		app.inputReader = new FileTextResourceReader(app.parameters.getInputFileName());
		app.dictionaryReader = new FileTextResourceReader(app.parameters.getDictFileName());
		app.run();
	}
	
	String singleLine = null;
	WordCount wordCount;
	WordCountUnique wordCountUnique;
	WordCountDictionary wordCountDictionary;

	SettingsParameters parameters;
	IConfigurationReader configurationReader;
	ITextResourceReader inputReader;
	ITextResourceReader dictionaryReader;
	
	public void run() {
		init();
		
		readInputFileContent();
		try {
			if (singleLine == null) {
				requestInput();
			}
			countAndWriteOutput();
			if (parameters.isIndex()) {
				printIndex();
			}
		} catch (IOException e) {
			System.err.println("Reading your command line input failed");
		}
	}
	
	public void init() {
		createWordCount();
		wordCountUnique = new WordCountUnique(wordCount);
	}
	
	public void initDictionary() {
		if (dictionaryReader != null) {
			Set<String> dictWords = new HashSet<String>(dictionaryReader.readLines());
			if (!dictWords.isEmpty()) {
				wordCountDictionary = new WordCountDictionary(dictWords);
			}
		}
	}
	
	private void countAndWriteOutput() {
		System.out.print("Number of words: ");
		System.out.print(wordCount.countWords(singleLine));
		System.out.print(", unique: ");
		System.out.print(wordCountUnique.countWords(singleLine));
		System.out.print("; average word length: ");
		System.out.print(df2Places.format(wordCount.averageWordLength(singleLine)));
		System.out.println(" characters");
	}
	
	private void printIndex() {
		List<String> uniqueWords = getIndex();
		System.out.println("Index:");
		for (String word : uniqueWords) {
			System.out.println(word);
		}
	}

	public List<String> getIndex() {
		List<String> uniqueWords = wordCountUnique.collectValidWords(singleLine);
		Collections.sort(uniqueWords, String::compareToIgnoreCase);
		return uniqueWords;
	}
	
	private void requestInput() throws IOException {
		System.out.println("Enter text: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		singleLine = reader.readLine();
	}
	
	public WordCount createWordCount() {
		wordCount = new WordCount();
		wordCount.setValidWordExp("[a-zA-Z\\-]+");
		wordCount.setWordsSeparator("[ ,\\t, \\.]+");
		initStopWords();
		return wordCount;
	}
	
	private void readInputFileContent() {
		if (inputReader != null) {
			singleLine = inputReader.readContent();
		}
	}
	
	/**
	 * 
	 * @param fileName
	 * @return null if file doesn't exist, otherwise the content (lines separated by 'nl' char)
	 */
	private void initStopWords() {
		if (configurationReader != null) {
			List<String> stopWords = configurationReader.readStopWords();
			if (stopWords != null) {
				wordCount.addStopWords(stopWords);
			}
		}
	}

}