package wordcount.Pojo;

public class CountWordsDTO {

	private long countDuplicatedWords;
	private long countTotalWords;
	private float averageWordLength;
	
	public CountWordsDTO() {}
	public CountWordsDTO(long countTotalWords, long countDuplicatedWords) {
		this.countTotalWords = countTotalWords;
		this.countDuplicatedWords = countDuplicatedWords;
	}
	
	public CountWordsDTO(long countTotalWords, long countDuplicatedWords, float averageWordLength) {
		this.countTotalWords = countTotalWords;
		this.countDuplicatedWords = countDuplicatedWords;
		this.averageWordLength = averageWordLength;
	}
	
	public long getCountDuplicatedWords() {
		return countDuplicatedWords;
	}
	
	public void setCountDuplicatedWords(long countDuplicatedWords) {
		this.countDuplicatedWords = countDuplicatedWords;
	}
	
	public long getTotalWordsCount() {
		return countTotalWords;
	}
	
	public void setCountTotalWords(long countWords) {
		this.countTotalWords = countWords;
	}
	
	public long getUniqueWordsCount() {
		long countUniqueWords = this.countTotalWords - this.countDuplicatedWords;
		return countUniqueWords;
	}
	
	public float getAverageWordLength() {
		return averageWordLength;
	}
	
	public void setAverageWordLength(float averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
}
