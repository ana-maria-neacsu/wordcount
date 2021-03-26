package at.george.hiring.wordcount.input;

public class InputSourceFactory {

    public static InputSource newInstance(String[] arguments) {
        if (arguments.length == 0 || arguments[0].startsWith("-index")) {
            return new ConsoleInputSourceImpl();
        } else {
            return new FileInputSourceImpl(arguments[0].trim());
        }
    }
}
