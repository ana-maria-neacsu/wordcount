import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void countWordsTest() {
        // ordinary lines
        Assert.assertEquals(4, Foo.countWords("Mary had a lamb"));
        Assert.assertEquals(4, Foo.countWords("Mary, had a lamb."));
        Assert.assertEquals(1, Foo.countWords("Mary"));
        Assert.assertEquals(8, Foo.countWords("Mary had a lamb. And Joe had two."));
        Assert.assertEquals(6, Foo.countWords("Mary had 1 lamb. And Joe had 2."));


        // weird input
        Assert.assertEquals(4, Foo.countWords("MaRY HAD A LaMb."));
        Assert.assertEquals(4, Foo.countWords(".Mary.had,a lamb"));
        Assert.assertEquals(0, Foo.countWords(""));
        Assert.assertEquals(0, Foo.countWords("H$ad"));
        Assert.assertEquals(0, Foo.countWords("541"));
        Assert.assertEquals(0, Foo.countWords(".,"));
        Assert.assertEquals(4, Foo.countWords(".Mary\thad,a lamb"));
        Assert.assertEquals(2, Foo.countWords("\tMary\t\t     had.    "));
        Assert.assertEquals(2, Foo.countWords("Mary h$d & lamb"));
    }
}
