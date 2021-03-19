package wordcount.helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsLoader {

    public List<String> loadStopWordsFromClassPath() {
        Stream<String> lines = null;

        try {
            URL resource = getClass().getClassLoader()
                    .getResource("stopwords.txt");
            if(Objects.isNull(resource)) {
                return Collections.emptyList();
            }
            Path path = Paths.get(resource.toURI());
            lines = Files.lines(path);
            return lines.collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (lines != null)
                lines.close();
        }

    }
}
