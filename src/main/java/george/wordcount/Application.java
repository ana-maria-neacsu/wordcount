package george.wordcount;

import george.wordcount.libraries.ConsoleUserInteractionFlow;
import george.wordcount.libraries.StopWordProvider;
import george.wordcount.logic.WordCounter;
import george.wordcount.ui.UserInteractionFlow;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;

public class Application {
    private UserInteractionFlow wireUp() throws IOException {
        final StopWordProvider stopWordProvider = new StopWordProvider();
        final WordCounter wordCounter = new WordCounter(
                stopWordProvider.provide()
        );

        return new ConsoleUserInteractionFlow(wordCounter, getPrintStream(), getInputStream());
    }

    protected PrintStream getPrintStream() {
        return System.out;
    }

    protected InputStream getInputStream() {
        return System.in;
    }

    public void wireUpAndExecute() throws IOException, URISyntaxException {
        final UserInteractionFlow commandPrompt = wireUp();

        commandPrompt.doInteraction();
    }
}
