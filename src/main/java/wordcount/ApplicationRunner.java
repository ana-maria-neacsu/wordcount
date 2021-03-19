package wordcount;

import wordcount.input.ConsoleInputReader;
import wordcount.input.InputReader;
import wordcount.operations.TextOperator;
import wordcount.operations.WordsCounter;
import wordcount.output.ConsoleOutputWriter;
import wordcount.output.OutputWriter;

import static wordcount.output.OutputFormatter.numberOfWordsFormatter;

public class ApplicationRunner {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        TextOperator textOperator = new WordsCounter();

        outputWriter.write("Enter text: ");
        String input = inputReader.readInput();

        outputWriter.write(numberOfWordsFormatter(textOperator.operate(input)));

    }
}
