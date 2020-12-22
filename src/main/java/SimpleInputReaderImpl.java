import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleInputReaderImpl implements InputReader {

    @Override
    public String readStandardInput() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public String readFile(String file) throws FileNotFoundException {
        final Scanner sc = new Scanner(new File(file));
        final StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append('\n');
        }

        return input.toString();
    }
}
