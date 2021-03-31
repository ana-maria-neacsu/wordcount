package george.wordcount.ui;

import george.wordcount.logic.WordCounter;

public abstract class UserInteractionFlow {
    private final WordCounter wordCounter;

    protected UserInteractionFlow(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public void doInteraction(final String[] args) {
        final String input = this.promptUserForString("Enter text: ");
        this.printText("Number of words: " + this.wordCounter.countWordsOf(input));
    }

    protected abstract void printText(String text);

    protected abstract String promptUserForString(String inputText);
}
