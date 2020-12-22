import java.util.Arrays;
import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;

public class InputSplitterTest {

    @Test
    public void testSimpleInputSplitting() {
        Assert.assertEquals(Arrays.asList("Mary", "had", "a", "lamb"), InputSplitter.splitInput("Mary had a lamb"));
    }

    @Test
    public void testHyphenInputSplitting() {
        Assert.assertEquals(Arrays.asList("Mary-had", "a", "lamb-cow"), InputSplitter.splitInput("Mary-had a lamb-cow"));
        Assert.assertEquals(Arrays.asList("Mary---had", "a", "lamb-cow"), InputSplitter.splitInput("Mary---had a lamb-cow"));
        Assert.assertEquals(Arrays.asList("lamb-cow"), InputSplitter.splitInput("--Mary-had- a- lamb-cow"));
        Assert.assertEquals(Collections.emptyList(), InputSplitter.splitInput("---d-- -- --- -"));
    }

    @Test
    public void testMultiLineInputSplitting() {
        Assert.assertEquals(Arrays.asList("Mary", "had", "a", "lamb"), InputSplitter.splitInput("Mary \n\n had a\nlamb\n"));
    }

    @Test
    public void testWeirdWhiteSpaceInputSplitting() {
        Assert.assertEquals(Arrays.asList("Mary", "had", "a", "lamb"),
                InputSplitter.splitInput("Mary \n\t had    a   lamb\n"));
    }

    @Test
    public void testCommasAndDotsInputSplitting() {
        Assert.assertEquals(Arrays.asList("Mary", "had", "a", "lamb"), InputSplitter.splitInput("Mary had,,a.lamb,"));
    }

    @Test
    public void testInputWithStrangeCharsSplitting() {
        Assert.assertEquals(Arrays.asList("Mar0", "had", "$", "l$mb"), InputSplitter.splitInput("Mar0 had,,$.l$mb,"));

    }

}