import java.util.List;

public class WordCount {

    public int countWords(List<String> input) {
        int count = 0;
        for (String w : input) {
            if (w.length() != 0) {
                count ++;
            }
        }
        return count;
    }
}


