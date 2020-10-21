package service;

import reader.ITextReader;

public class ReaderService {
    private final ITextReader textReader;

    public ReaderService(ITextReader textReader) {
        this.textReader = textReader;
    }

    public int countWordsInText(final String text) {
        return textReader.readTextAndCountWords(text);
    }
}