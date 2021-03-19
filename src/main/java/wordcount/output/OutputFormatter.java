package wordcount.output;

public class OutputFormatter {

    private static String numberOfWordsFormatter(long number) {
        return "Number of words: " + number;
    }

    private static String numberOfUniqueWordsMessageFormatter(long number) {
        return "unique: " + number;
    }

    private static String appendMessageWithCommaAndSpace(String message) {
        return message + ", ";
    }

    public static String numberOfWordsFormatterWithUniqueWords(long wordsCount, long uniqueWordsCount) {
       return appendMessageWithCommaAndSpace(numberOfWordsFormatter(wordsCount))
               + numberOfUniqueWordsMessageFormatter(uniqueWordsCount);
    }
}
