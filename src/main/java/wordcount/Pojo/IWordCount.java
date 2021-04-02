package wordcount.Pojo;

import java.util.ArrayList;

public interface IWordCount {
	
	public long count();
	public void setText(String text);
	public void setStopWordsReader(String fileName);
	void setText(ArrayList<String> words);
	void setText(ArrayList<String> words, String stopWordsFileName);
}
