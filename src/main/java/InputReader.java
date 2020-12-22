import java.io.FileNotFoundException;

public interface InputReader {
    String readStandardInput();

    String readFile(String file) throws FileNotFoundException;
}
