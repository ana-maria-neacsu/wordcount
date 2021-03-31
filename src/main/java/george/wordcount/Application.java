package george.wordcount;

import george.wordcount.libraries.ConsoleUserInteractionFlow;
import george.wordcount.ui.UserInteractionFlow;

public class Application {
    private static UserInteractionFlow wireUp() {
        return new ConsoleUserInteractionFlow(System.in, System.out);
    }

    public static void main(String[] args) {
        final UserInteractionFlow commandPrompt = wireUp();

        commandPrompt.doInteraction();
    }
}
