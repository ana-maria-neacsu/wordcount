package wordcount.readers;

import java.io.InputStream;
import java.util.List;

public interface Reader {
    List<String> read(InputStream inputStream);
}
