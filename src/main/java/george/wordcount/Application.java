package george.wordcount;

import george.wordcount.libraries.ConsoleUserInteractionFlow;
import george.wordcount.logic.WordCounter;
import george.wordcount.ui.UserInteractionFlow;

public class Application {
    private static UserInteractionFlow wireUp() {
        final WordCounter wordCounter = new WordCounter();

        return new ConsoleUserInteractionFlow(wordCounter, System.out, System.in);
    }

    public static void main(String[] args) {
        final UserInteractionFlow commandPrompt = wireUp();

        commandPrompt.doInteraction();
    }
}
