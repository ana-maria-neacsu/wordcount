import org.junit.Assert
import org.junit.Test

class WordCounterTest {

    private val simpleWordCounter = LatinWordCounter()

    @Test
    fun `test count of one word without whitespaces`() {
        val expectedCount = 1
        val actualCount = simpleWordCounter.count("word")

        Assert.assertEquals("Word count didn't match...", expectedCount, actualCount)
    }

    @Test
    fun `test no word count if a wrong symbols in a word exist`() {
        val expectedCount = 0
        val actualCount = simpleWordCounter.count("word!")

        Assert.assertEquals("Word count didn't match...", expectedCount, actualCount)
    }

    @Test
    fun `test count of multiple words with whitespaces`() {
        val expectedCount = 3
        val actualCount = simpleWordCounter.count("word word word")

        Assert.assertEquals("Word count should return 3 as an actual count", expectedCount, actualCount)
    }

    @Test
    fun `test no words with legal character are found`() {
        val expectedCount = 0
        val actualCount = simpleWordCounter.count("word, word. word!")

        Assert.assertEquals("Word count shouldn't find any words in this example", expectedCount, actualCount)
    }

    @Test
    fun `test complex input with illegal words, multiple whitespaces and one single word`() {
        val expectedCount = 1
        val actualCount = simpleWordCounter.count("1Foo Ba3r.           Word")

        Assert.assertEquals("There should be only one legal word", expectedCount, actualCount)
    }

    @Test
    fun `test empty string returns zero count of words`() {
        val expectedCount = 0
        val actualCount = simpleWordCounter.count("")

        Assert.assertEquals("There are no words in empty string", expectedCount, actualCount)
    }

    @Test
    fun `test a single word surrounded by whitespaces`() {
        val expectedCount = 1
        val actualCount = simpleWordCounter.count("      SomeWord       ")

        Assert.assertEquals("There is only one word surrounded by whitespaces", expectedCount, actualCount)
    }

    @Test
    fun `test zero words when a word is attached to tab character`() {
        val expectedCount = 0
        val actualCount = simpleWordCounter.count("SomeWord\t")

        Assert.assertEquals("There is no legal word in the input text", expectedCount, actualCount)
    }
}