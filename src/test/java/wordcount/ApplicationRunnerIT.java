package wordcount;

import org.junit.jupiter.api.Test;

public class ApplicationRunnerIT {
    String[] inputArgument = new String[]{ "C:\\Code\\wordcount\\src\\test\\resources\\mytext.txt" };

    @Test
    public void mainTest() {
        ApplicationRunner.main(inputArgument);
    }
}
