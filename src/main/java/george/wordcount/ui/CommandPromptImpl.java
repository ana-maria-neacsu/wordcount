package george.wordcount.ui;

public class CommandPromptImpl implements CommandPrompt {
    private final TextInputOutput textInputOutput;

    public CommandPromptImpl(TextInputOutput textInputOutput) {
        this.textInputOutput = textInputOutput;
    }

    @Override
    public void doInteraction() {
        this.textInputOutput.printText("==== Word Count ====");
        this.textInputOutput.promptUser("Enter text:");
    }
}
