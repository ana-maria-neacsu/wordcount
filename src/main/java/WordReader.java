import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordReader {

    public List<String> readWords(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("[^a-zA-Z]]");
        List<String> words = new LinkedList<String>();
        while (scanner.hasNext()) {
            String next = scanner.next();
            words.add(next);
        }
        return words;
    }
}
