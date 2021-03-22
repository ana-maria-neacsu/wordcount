package wordcount.interview.mock;

import wordcount.interview.domain.WordCountDefault;

public class WordCountDefaultMock extends WordCountDefault {
    private boolean runCalled;

    public WordCountDefaultMock() {
        super(null, null, null);
        this.runCalled = runCalled;
    }

    @Override
    public void run() {
        runCalled = true;
    }

    public boolean isRunCalled() {
        return runCalled;
    }
}
