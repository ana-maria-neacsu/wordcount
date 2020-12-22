import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    static class Result {
        private final int uniqueCount;
        private final int overallCount;

        Result(final int uniqueCount, final int overallCount) {
            this.uniqueCount = uniqueCount;
            this.overallCount = overallCount;
        }

        public int getUniqueCount() {
            return uniqueCount;
        }

        public int getOverallCount() {
            return overallCount;
        }
    }

    public static Result countWords(final String input, final Set<String> stopWords) {
        final String[] possibleWords = input.split(",|\\.|\\s+");

        // just in case convert all stop words into the lowercase - the match should be case insensitive
        final Set<String> loverCaseStopWords = stopWords.stream().map(String::toLowerCase).collect(Collectors.toSet());

        int countOfActualWords = 0;
        final Set<String> uniqueWords = new HashSet<>();
        for (final String possibleWord: possibleWords) {
            // convert to lowercase, so we can more easily check if the word is actual word and if it is not in stop
            // words, these should be already lowercase
            final String lowerCaseWord = possibleWord.toLowerCase();
            if (lowerCaseWord.matches("[a-z-]+") && !loverCaseStopWords.contains(lowerCaseWord)) {
                countOfActualWords++;
                uniqueWords.add(lowerCaseWord);
            }
        }

        return new Result(uniqueWords.size(), countOfActualWords);
    }
}
