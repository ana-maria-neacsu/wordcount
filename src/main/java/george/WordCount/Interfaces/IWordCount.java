package george.WordCount.Interfaces;

import java.util.ArrayList;

import wordcount.Pojo.CountWordsDTO;

public interface IWordCount {
	
	public CountWordsDTO count();
	public void setText(String text);
	public void setStopWordsReader(String fileName);
	void setText(ArrayList<String> words);
	void setText(ArrayList<String> words, String stopWordsFileName);
}
