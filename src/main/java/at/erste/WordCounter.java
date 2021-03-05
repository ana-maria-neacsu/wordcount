package at.erste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

    int count(String input){
        int count = 0;

        String[] strings = input.split("\\s+");
        for (String word : strings) {
            Matcher m = pattern.matcher(word);
            if(m.matches()){
                count++;
            }
        }
        return count;
    }
}
