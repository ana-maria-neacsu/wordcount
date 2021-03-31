package george.wordcount;

import george.wordcount.libraries.ConsoleUserInteractionFlow;
import george.wordcount.libraries.StopWordProvider;
import george.wordcount.logic.WordCounter;
import george.wordcount.ui.UserInteractionFlow;

import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private static UserInteractionFlow wireUp() throws IOException, URISyntaxException {
        final StopWordProvider stopWordProvider = new StopWordProvider();
        final WordCounter wordCounter = new WordCounter(
                stopWordProvider.provide()
        );

        return new ConsoleUserInteractionFlow(wordCounter, System.out, System.in);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        final UserInteractionFlow commandPrompt = wireUp();

        commandPrompt.doInteraction();
    }
}
