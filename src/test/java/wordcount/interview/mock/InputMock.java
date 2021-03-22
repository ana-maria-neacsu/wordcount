package wordcount.interview.mock;

import wordcount.interview.ui.input.Input;

public class InputMock implements Input {
    private final String inputText;

    public InputMock(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public String read() {
        return inputText;
    }
}
