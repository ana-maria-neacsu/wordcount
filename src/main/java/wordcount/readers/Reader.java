package wordcount.readers;

import java.io.InputStream;
import java.util.Collection;

public interface Reader {
    Collection<String> read(InputStream inputStream);
}
