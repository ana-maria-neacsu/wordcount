import org.junit.Assert
import org.junit.Test

class WordCounterTest {

    private val simpleWordCounter = getLatinWordCounter()

    @Test
    fun `test count of one word without whitespaces`() {
        val expectedCount = WordCount(1, 1)
        val actualCount = simpleWordCounter.count("word")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test count of multiple words with whitespaces`() {
        val expectedCount = WordCount(3, 1)
        val actualCount = simpleWordCounter.count("word word word")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count separated by special characters`() {
        val expectedCount =  WordCount(15, 1)
        val actualCount = simpleWordCounter.count("word, word. word! word# word? word! word@ word\$ word% word^ word& word* word- word. word,")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test complex input with illegal words, multiple whitespaces and one single word`() {
        val expectedCount = WordCount(1, 1)
        val actualCount = simpleWordCounter.count("1Foo Ba3r.           Word")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test empty string returns zero count of words`() {
        val expectedCount = WordCount(0, 0)
        val actualCount = simpleWordCounter.count("")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test a single word surrounded by whitespaces`() {
        val expectedCount = WordCount(1, 1)
        val actualCount = simpleWordCounter.count("      SomeWord       ")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test zero words when a word is attached to a special character`() {
        val expectedCount = WordCount(1, 1)
        val actualCount = simpleWordCounter.count("SomeWord\t")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count with ignored stopwords`() {
        val wordCounterWithStopWords = getLatinWordCounter("a")
        val expectedCount = WordCount(4, 4)
        val actualCount = wordCounterWithStopWords.count("Mary had a little lamb")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test all words are stopwords with different cases`() {
        val wordCounterWithStopWords = getLatinWordCounter("a", "the", "on", "off", "on")
        val expectedCount = WordCount(0, 0)
        val actualCount = wordCounterWithStopWords.count("On the A on ofF")

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count with duplicated words`() {
        val wordCounterWithStopWords = getLatinWordCounter("a", "the", "on", "off")
        val expectedCount = WordCount(9, 7)
        val actualCount = wordCounterWithStopWords.count("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        Assert.assertEquals(expectedCount, actualCount)
    }

    private fun getLatinWordCounter(vararg stopWords: String): WordCounter {
        return LatinWordCounter(MockedStopWordsProvider(stopWords.asList()))
    }

    class MockedStopWordsProvider(
            private val stopWords: List<String>
    ) : StopWordsProvider
    {
        override fun getStopWords(): Set<String> {
            return stopWords.toSet()
        }
    }
}