import java.io.FileNotFoundException;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final WordCounter counter = new WordCounter(new InputReaderImpl());
        System.out.println("Number of words: " + counter.count(args));
    }
}
