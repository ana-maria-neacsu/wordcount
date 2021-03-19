package wordcount.output;

import wordcount.contract.output.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void write(String output) {
        System.out.print(output);
    }
}
