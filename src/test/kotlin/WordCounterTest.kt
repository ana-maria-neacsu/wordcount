import org.junit.Assert
import org.junit.Test

class WordCounterTest {

    private val simpleWordCounter = SimpleWordCounter()

    @Test
    fun `test successful count of one word without whitespaces`() {
        val expectedCount = 1
        val actualCount = simpleWordCounter.count("word")

        Assert.assertEquals("Word count didn't match...", expectedCount, actualCount)
    }

    @Test
    fun `test successful no word count if a wrong symbols in a word exist`() {
        val expectedCount = 0
        val actualCount = simpleWordCounter.count("word!")

        Assert.assertEquals("Word count didn't match...", expectedCount, actualCount)
    }

    @Test
    fun `test successful count of multiple words with whitespaces`() {
        val expectedCount = 3
        val actualCount = simpleWordCounter.count("word word word")

        Assert.assertEquals("Word count didn't match...", expectedCount, actualCount)
    }

    
}