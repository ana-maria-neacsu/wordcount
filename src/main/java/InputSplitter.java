import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class InputSplitter {
    public static Collection<String> splitInput(String input) {
        final String[] possibleWordsWithTrailingOrLeadingHyphens = input.split(",|\\.|\\s+");

        return Arrays.stream(possibleWordsWithTrailingOrLeadingHyphens)
                // filter out words that starts or ends with hyphen
                .filter(s -> !s.endsWith("-") && !s.startsWith("-"))
                // there can be some empty strings in the split, filter them out
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());
    }
}
