package george.wordcount;

import java.io.IOException;
import java.net.URISyntaxException;

public class EntryPoint {
    public static void main(String[] args) throws IOException, URISyntaxException {
        final Application application = new Application();

        application.wireUpAndExecute();
    }
}
