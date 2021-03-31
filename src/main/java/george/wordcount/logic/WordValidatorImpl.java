package george.wordcount.logic;

public class WordValidatorImpl implements WordValidator {
    @Override
    public boolean isValidWord(final String potentialWord) {
        if (potentialWord == null) {
            return false;
        }

        final boolean isNonEmpty = !potentialWord.isEmpty();
        final boolean containsOnlyValidCharacters = containsOnlyValidCharacters(potentialWord);

        return isNonEmpty && containsOnlyValidCharacters;
    }

    private boolean containsOnlyValidCharacters(final String input) {
        for (char character : input.toCharArray()) {
            if (!isValidCharacter(character)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidCharacter(final Character input) {
        final boolean isUpperCaseLetter = (input >= 'A') && (input <= 'Z');
        final boolean isLowerCaseLetter = (input >= 'a') && (input <= 'z');

        return isUpperCaseLetter || isLowerCaseLetter;
    }
}
