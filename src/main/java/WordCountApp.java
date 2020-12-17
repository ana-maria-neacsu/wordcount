import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class WordCountApp {

    WordReader wordReader = new WordReader();
    WordCount wordCount = new WordCount();

    public int count(InputStream inputStream) {
        List<String> words = wordReader.readWords(inputStream);

        return wordCount.countWords(words);
    }

    public static void main(String[] args) {
        WordCountApp wordCountApp = new WordCountApp();
        System.out.println("Enter text:");

        System.out.println("Number of words: " + wordCountApp.count(System.in));
    }
}
