import java.io.FileNotFoundException;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final App counter = new App(new InputReaderImpl());
        System.out.println("Number of words: " + counter.count(args));
    }
}
