package george.wordcount.libraries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StopWordProvider {
    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    public List<String> provide() throws IOException {
        final InputStream inputStream =
                StopWordProvider.class.getClassLoader().getResourceAsStream(STOPWORDS_FILE_PATH);

        return convertFromInputStream(inputStream);
    }

    private List<String> convertFromInputStream(final InputStream inputStream) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final List<String> result = new LinkedList<>();

        while (reader.ready()) {
            result.add(reader.readLine());
        }

        return result;
    }
}
