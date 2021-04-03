package at.george.wordcount;

import java.util.Arrays;
import java.util.regex.Pattern;

public class WordCountService {

    private final Pattern wordPattern = Pattern.compile(".*[A-Za-z]+.*");

    public long countWords(String text) {
        if (text == null || text.trim().length() == 0) {
            return 0;
        }
        return Arrays.stream(text.trim().split("[ ,\\-\t\n]"))
                .filter(word -> wordPattern.matcher(word).matches())
                .count();
    }
}
