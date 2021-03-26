package at.george.hiring.wordcount.output;

public class ConsoleSinkImpl implements OutputSink {
    @Override
    public void print(String logMessage) {
        System.out.print(logMessage);
    }
}
