import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class FooTest {

    @Test
    public void testGetStopWordsNoFileExists() {
        // if no file exists should return empty set
        Assert.assertEquals(0, Foo.getStopWords().size());
    }

    @Test
    public void countWordsTestWithNoStopWords() {
        // ordinary lines
        Assert.assertEquals(4, Foo.countWords("Mary had a lamb", new HashSet<String>()));
        Assert.assertEquals(4, Foo.countWords("Mary, had a lamb.", new HashSet<String>()));
        Assert.assertEquals(1, Foo.countWords("Mary", new HashSet<String>()));
        Assert.assertEquals(8, Foo.countWords("Mary had a lamb. And Joe had two.", new HashSet<String>()));
        Assert.assertEquals(6, Foo.countWords("Mary had 1 lamb. And Joe had 2.", new HashSet<String>()));


        // weird input
        Assert.assertEquals(4, Foo.countWords("MaRY HAD A LaMb.", new HashSet<String>()));
        Assert.assertEquals(4, Foo.countWords(".Mary.had,a lamb", new HashSet<String>()));
        Assert.assertEquals(0, Foo.countWords("", new HashSet<String>()));
        Assert.assertEquals(0, Foo.countWords("H$ad", new HashSet<String>()));
        Assert.assertEquals(0, Foo.countWords("541", new HashSet<String>()));
        Assert.assertEquals(0, Foo.countWords(".,", new HashSet<String>()));
        Assert.assertEquals(4, Foo.countWords(".Mary\thad,a lamb", new HashSet<String>()));
        Assert.assertEquals(2, Foo.countWords("\tMary\t\t     had.    ", new HashSet<String>()));
        Assert.assertEquals(2, Foo.countWords("Mary h$d & lamb", new HashSet<String>()));
    }

    @Test
    public void countWordsTestWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(2, Foo.countWords("Mary had a lamb", stopWords));
        Assert.assertEquals(0, Foo.countWords("Mary, MARY, mary, LAMB, Lamb", stopWords));
        Assert.assertEquals(4, Foo.countWords("Joe had a sheep", stopWords));

        final Set<String> strangeStopWords = new HashSet<>(Collections.singletonList("Mary had a lamb"));
        Assert.assertEquals(4, Foo.countWords("Mary had a lamb", strangeStopWords));

        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(4, Foo.countWords("Mary had a lamb", emptyStopWords));
    }
}
