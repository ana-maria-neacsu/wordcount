import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void countWordTest() {
        // ordinary lines
        Assert.assertEquals(4, Foo.wordCount("Mary had a lamb"));
        Assert.assertEquals(4, Foo.wordCount("Mary, had a lamb."));
        Assert.assertEquals(1, Foo.wordCount("Mary"));

        // weird input
        Assert.assertEquals(4, Foo.wordCount(".Mary.had,a lamb"));
        Assert.assertEquals(0, Foo.wordCount(""));
        Assert.assertEquals(0, Foo.wordCount(".,"));
        Assert.assertEquals(4, Foo.wordCount(".Mary\thad,a lamb"));
        Assert.assertEquals(4, Foo.wordCount("\tMary\t\t     had.    "));
        Assert.assertEquals(3, Foo.wordCount("Mary h$d & lamb"));
    }
}
