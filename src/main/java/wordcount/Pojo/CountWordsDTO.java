package wordcount.Pojo;

public class CountWordsDTO {

	private long countDuplicatedWords;
	private long countTotalWords;
	
	public CountWordsDTO() {}
	public CountWordsDTO(long countTotalWords, long countDuplicatedWords) {
		this.countTotalWords = countTotalWords;
		this.countDuplicatedWords = countDuplicatedWords;
	}
	
	public long getCountDuplicatedWords() {
		return countDuplicatedWords;
	}
	
	public void setCountDuplicatedWords(long countDuplicatedWords) {
		this.countDuplicatedWords = countDuplicatedWords;
	}
	
	public long getCountTotalWords() {
		return countTotalWords;
	}
	
	public void setCountTotalWords(long countWords) {
		this.countTotalWords = countWords;
	}
	
	public long getCountUniqueWords() {
		long countUniqueWords = this.countTotalWords - this.countDuplicatedWords;
		return countUniqueWords;
	}
}
