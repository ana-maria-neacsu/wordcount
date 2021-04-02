package wordcount.Pojo;

public class CountWordsDTO {

	private long countUniqueWords;
	private long countWords;
	
	public CountWordsDTO() {}
	public CountWordsDTO(long countWords, long countUniqueWords) {
		this.countWords = countWords;
		this.countUniqueWords = countUniqueWords;
	}
	
	public long getCountUniqueWords() {
		return countUniqueWords;
	}
	public void setCountUniqueWords(long countUniqueWords) {
		this.countUniqueWords = countUniqueWords;
	}
	public long getCountWords() {
		return countWords;
	}
	public void setCountWords(long countWords) {
		this.countWords = countWords;
	}
}
