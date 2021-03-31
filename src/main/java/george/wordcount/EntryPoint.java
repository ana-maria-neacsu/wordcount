package george.wordcount;

import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        final Application application = new Application();

        application.wireUpAndExecute(args);
    }
}
