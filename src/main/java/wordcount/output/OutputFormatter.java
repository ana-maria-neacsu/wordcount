package wordcount.output;

public class OutputFormatter {

    public static String numberOfWordsFormatterWithUniqueWords(long wordsCount, long uniqueWordsCount, double averageOfWords) {
        return String.format("Number of words: %s, unique: %s; average word length: %.2f characters", wordsCount, uniqueWordsCount, averageOfWords);
    }
}
