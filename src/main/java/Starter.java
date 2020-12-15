import com.george.ports.ConsoleInputReader;
import com.george.domain.SimpleWordCounter;

public class Starter {

    public static void main(String[] args) {
        String input = new ConsoleInputReader().read();
        System.out.println(new SimpleWordCounter().count(input));

    }
}
