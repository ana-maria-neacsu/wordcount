package george.wordcount.ui;

public abstract class UserInteractionFlow {
    public void doInteraction() {
        this.printText("==== Word Count ====");
        final String input = this.promptUserForString("Enter text:");
        this.printText("received text: " + input);
    }

    protected abstract void printText(String text);

    protected abstract String promptUserForString(String inputText);
}
