package wordcount.Pojo;

public class WordCount {

	private String text;
	private int count;
	private String[] listOfWords;
	private static final String ONLY_LETTERS_REGEX = "^[a-zA-Z]+$";
	
	public WordCount(String text) {
		this.setText(text);
		this.count = 0;
		splitTextWords();
	}
	
	public int count() {

		for(String word : listOfWords){
			Boolean hasOnlyLetters = word.matches(ONLY_LETTERS_REGEX);
			if(hasOnlyLetters)
				count++;
		}
		
		return count;
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
