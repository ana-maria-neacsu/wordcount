package at.erste.words;

import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public int count(final String input){
        int count = 0;

        String[] strings = input.split("\\s+");
        for (String word : strings) {
            if(pattern.matcher(word).matches()){
                count++;
            }
        }
        return count;
    }
}
