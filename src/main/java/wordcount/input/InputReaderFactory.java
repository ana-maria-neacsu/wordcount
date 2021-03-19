package wordcount.input;

import wordcount.contract.input.InputReader;

import java.util.Objects;

public final class InputReaderFactory {
    public static InputReader getInputReader(String[] args) {
        if (Objects.isNull(args) || args.length == 0) {
            return new ConsoleInputReader();
        }
        return new FileInputReader(args[0]);
    }
}
