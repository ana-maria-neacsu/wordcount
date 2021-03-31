package george.wordcount.ui;

import george.wordcount.logic.WordCounter;

public abstract class UserInteractionFlow {
    private final WordCounter wordCounter;

    protected UserInteractionFlow(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public void doInteraction(final String[] args) {
        if (argumentsAreNotValid(args)) {
            this.printText("Either no or one command line argument is allowed");
            return;
        }

        final String text = retrieveInput(args);

        this.printText("Number of words: " + this.wordCounter.countWordsOf(text));
    }

    private boolean argumentsAreNotValid(final String[] args) {
        return countArguments(args) > 1;
    }

    private int countArguments(final String[] args) {
        if (args == null) {
            return 0;
        }

        return args.length;
    }

    private String retrieveInput(final String[] args) {
        final boolean readInputFromConsole = countArguments(args) == 0;

        if (readInputFromConsole) {
            return readInputFromConsoleMode();
        } else {
            return readInputFromFile(args[0]);
        }
    }

    private String readInputFromConsoleMode() {
        return this.promptUserForString("Enter text: ");
    }

    private String readInputFromFile(final String filePath) {
        // TODO:
        // - implement FileContentProvider in libraries package
        // - then call here and merge the lines into one string (replace line separators with whitespaces)
        return "";
    }

    protected abstract void printText(String text);

    protected abstract String promptUserForString(String inputText);
}
