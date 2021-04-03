package at.george.wordcount;

import java.util.Objects;
import java.util.Optional;

public class CLICallArguments {
    private boolean index;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<String> inputFile;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<String> dictionary;

    public static CLICallArguments fromArgs(String[] args) {
        Objects.requireNonNull(args, "'args' must be supplied!");
        CLICallArguments parsed = new CLICallArguments(false, Optional.empty(), Optional.empty());

        for (String arg : args) {
            if ("-index".equalsIgnoreCase(arg)) {
                parsed.index = true;
            } else if (arg.startsWith("-dictionary")) {
                extractDictionary(parsed, arg);
            } else {
                extractFile(parsed, arg);
            }
        }
        return parsed;
    }

    private static void extractDictionary(CLICallArguments parsed, String arg) {
        if (parsed.dictionary.isPresent()) {
            throw new IllegalArgumentException("Please only supply at most one dictionary-argument!");
        }
        if ((arg.length() - "-dictionary".length()) < 2) {
            throw new IllegalArgumentException("Please supply a dictionary arg (with -dictionary=dict.txt)!");
        }
        String dictionary = arg.substring("-dictionary=".length());
        parsed.dictionary = Optional.of(dictionary);
    }

    private static void extractFile(CLICallArguments parsed, String arg) {
        if (parsed.inputFile.isPresent()) {
            throw new IllegalArgumentException("Please only supply at most 1 non-option-argument - the filename of the words!");
        }
        parsed.inputFile = Optional.of(arg);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public CLICallArguments(boolean index, Optional<String> inputFile, Optional<String> dictionary) {
        this.index = index;
        this.inputFile = inputFile;
        this.dictionary = dictionary;
    }

    public boolean isIndex() {
        return index;
    }

    public Optional<String> getInputFile() {
        return inputFile;
    }

    public Optional<String> getDictionary() {
        return dictionary;
    }
}
