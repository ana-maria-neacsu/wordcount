import org.junit.Assert
import org.junit.Test

class WordCounterTest {

    private val simpleWordCounter = getLatinWordCounter()

    @Test
    fun `test count of one word without whitespaces`() {
        val expectedCount = WordCount(1, 1, 4.0, listOf(WordFromIndex("word")))
        val actualCount = simpleWordCounter . count ("word", setOf("word"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test count of multiple words with whitespaces`() {
        val expectedCount = WordCount(3, 1, 4.0, (1..3).map { WordFromIndex("word") })
        val actualCount = simpleWordCounter.count("word word word", setOf("word"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count separated by special characters`() {
        val expectedCount = WordCount(15, 2, 61.0 / 15.0, (1..14).map { WordFromIndex("word") } + listOf(WordFromIndex("word-")))
        val actualCount = simpleWordCounter.count("word, word. word! word# word? word! word@ word\$ word% word^ word& word* word- word. word,", setOf("word", "word-"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test complex input with illegal words, multiple whitespaces and one single word`() {
        val expectedCount = WordCount(1, 1, 4.0, listOf(WordFromIndex("Word")))
        val actualCount = simpleWordCounter.count("1Foo Ba3r.           Word", setOf("Word"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test empty string returns zero count of words`() {
        val expectedCount = WordCount(0, 0, 0.0)
        val actualCount = simpleWordCounter.count("", emptySet())

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test a single word surrounded by whitespaces`() {
        val expectedCount = WordCount(1, 1, 8.0, listOf(WordFromIndex("SomeWord")))
        val actualCount = simpleWordCounter.count("      SomeWord       ", setOf("SomeWord"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test zero words when a word is attached to a special character`() {
        val expectedCount = WordCount(1, 1, 8.0, listOf(WordFromIndex("SomeWord")))
        val actualCount = simpleWordCounter.count("SomeWord\t", setOf("SomeWord"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count with ignored stopwords and no word in a dictionary`() {
        val wordCounterWithStopWords = getLatinWordCounter("a")
        val expectedCount = WordCount(4, 4, 17.0 / 4,
                listOf(
                        WordFromIndex("had", true),
                        WordFromIndex("lamb", true),
                        WordFromIndex("little", true),
                        WordFromIndex("Mary", true)
                ))
        val actualCount = wordCounterWithStopWords.count("Mary had a little lamb", emptySet())

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test all words are stopwords with different cases`() {
        val wordCounterWithStopWords = getLatinWordCounter("a", "the", "on", "off", "on")
        val expectedCount = WordCount(0, 0, 0.0)
        val actualCount = wordCounterWithStopWords.count("On the A on ofF", emptySet())

        Assert.assertEquals(expectedCount, actualCount)
    }

    @Test
    fun `test words count with duplicated words and some words being in a dictionary`() {
        val wordCounterWithStopWords = getLatinWordCounter("a", "the", "on", "off")
        val expectedCount = WordCount(7, 6, 45.0 / 7,
                listOf(
                        WordFromIndex("fall"),
                        WordFromIndex("great", true),
                        WordFromIndex("had", true),
                        WordFromIndex("Humpty-Dumpty"),
                        WordFromIndex("Humpty-Dumpty"),
                        WordFromIndex("sat"),
                        WordFromIndex("wall")
                ))
        val actualCount = wordCounterWithStopWords.count("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", setOf("Fall", "humpty-dumpty", "sat", "Wall"))

        Assert.assertEquals(expectedCount, actualCount)
    }

    private fun getLatinWordCounter(vararg stopWords: String): WordCounter {
        return LatinWordCounter(MockedStopWordsProvider(stopWords.asList()))
    }

    class MockedStopWordsProvider(
            private val stopWords: List<String>
    ) : StopWordsProvider {
        override fun getStopWords(): Set<String> {
            return stopWords.toSet()
        }
    }
}