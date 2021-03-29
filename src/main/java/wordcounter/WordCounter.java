package wordcounter;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    /**
     * This method returns number of words found in a text.
     * Words are defined as stretches of letters (a-z,A-Z)
     * @param text input text
     * @return number of words found
     */
    public int count(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        //via regex
        Pattern pattern = Pattern.compile("[a-zA-Z]");

        String[] words = text.split("\\s+");
        int totalCount = 0;
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                totalCount++;
            }
        }
        return totalCount;
        //final String[] words = text.split("");
        //return words.length;
    }
}
