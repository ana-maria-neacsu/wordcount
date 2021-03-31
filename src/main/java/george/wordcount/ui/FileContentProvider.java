package george.wordcount.ui;

import java.util.List;

public interface FileContentProvider {
    List<String> readAllLinesFromFile(String path);
}
