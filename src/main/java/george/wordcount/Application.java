package george.wordcount;

import george.wordcount.libraries.JavaConsoleInputOutput;
import george.wordcount.ui.CommandPrompt;
import george.wordcount.ui.CommandPromptImpl;
import george.wordcount.ui.TextInputOutput;

public class Application {
    private static CommandPrompt wireUp() {
        final TextInputOutput textInputOutput = new JavaConsoleInputOutput(System.console());

        final CommandPrompt commandPrompt = new CommandPromptImpl(textInputOutput);

        return commandPrompt;
    }

    public static void main(String[] args) {
        final CommandPrompt commandPrompt = wireUp();

        commandPrompt.doInteraction();
    }
}
