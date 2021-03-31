package george.wordcount.logic;

import java.util.LinkedList;
import java.util.List;

public class WordCountImpl implements WordCount {
    @Override
    public int countWordsOf(final String input) {
        final List<Character> validInput = validateAndConvertFrom(input);

        return countWordsOf(validInput);
    }

    private int countWordsOf(final List<Character> input) {
        int words = 0;

        while (!input.isEmpty()) {
            eatWhiteSpaces(input);
            final boolean ateWord = eatWord(input);

            if (ateWord) {
                words++;
            }
        }

        return words;
    }

    private void eatWhiteSpaces(List<Character> input) {
        while (firstCharacterExistsAndIsWhitespace(input)) {
            input.remove(0);
        }
    }

    private boolean eatWord(List<Character> input) {
        while (firstCharacterExistsAndIsLetter(input)) {
            input.remove(0);
        }

        // TODO: do we need to check whether we really ate letters ?

        return lastCharacterDoesntExistOrIsWhitespace(input);

return false;

        // check that last character either doesn't exist or is a whitespace otherwise it is not a word
    }

    private boolean firstCharacterExistsAndIsWhitespace(List<Character> input) {
        if (input.isEmpty()) {
            return false;
        }

        final char firstCharacter = input.get(0);

        return Character.isWhitespace(firstCharacter);
    }

    private boolean firstCharacterExistsAndIsLetter(List<Character> input) {
        if (input.isEmpty()) {
            return false;
        }

        final char firstCharacter = input.get(0);

        return Character.isLetter(firstCharacter);
    }

    private List<Character> validateAndConvertFrom(final String input) {
        if (input == null) {
            return new LinkedList<>();
        }

        final List<Character> result = new LinkedList<>();

        for (char character : input.toCharArray()) {
            result.add(character);
        }

        return result;
    }

}
