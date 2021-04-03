package at.george.wordcount;

import java.util.Objects;
import java.util.Optional;

public class CLICallArguments {
    private boolean index;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<String> inputFile;

    public static CLICallArguments fromArgs(String[] args) {
        Objects.requireNonNull(args, "'args' must be supplied!");
        CLICallArguments parsed = new CLICallArguments(false, Optional.empty());

        for (String arg : args) {
            if ("-index".equalsIgnoreCase(arg)) {
                parsed.index = true;
            } else {
                if (parsed.inputFile.isPresent()) {
                    throw new IllegalArgumentException("Please only supply at most 1 non-option-argument - the filename of the words!");
                }
                parsed.inputFile = Optional.of(arg);
            }
        }
        return parsed;
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public CLICallArguments(boolean index, Optional<String> inputFile) {
        this.index = index;
        this.inputFile = inputFile;
    }

    public boolean isIndex() {
        return index;
    }

    public Optional<String> getInputFile() {
        return inputFile;
    }
}
