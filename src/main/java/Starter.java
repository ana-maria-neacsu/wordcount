import com.george.domain.ConsoleInputReader;
import com.george.domain.WordCounter;

public class Starter {

    public static void main(String[] args) {
        String input = new ConsoleInputReader().read();
        System.out.println(new WordCounter().count(input));

    }
}
