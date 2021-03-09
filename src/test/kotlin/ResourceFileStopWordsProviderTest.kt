import org.junit.Assert
import org.junit.Test

class ResourceFileStopWordsProviderTest {

    @Test
    fun `test no resource file is given throws an exception`()
    {
        val stopWordsProvider = ResourceFileStopWordsProvider("\\notExistingFile.txt")

        Assert.assertThrows(NoResourceFileWithStopWordsFound::class.java) { stopWordsProvider.getStopWords() }
    }

    @Test
    fun `test empty file creates empty set of stopwords`()
    {
        val stopWordsProvider = ResourceFileStopWordsProvider("\\emptyFile.txt")

        val actualStopWords = stopWordsProvider.getStopWords()
        Assert.assertTrue(actualStopWords.isEmpty())
    }

    @Test
    fun `test simple tokens with duplicates and different cases for characters`()
    {
        val stopWordsProvider = ResourceFileStopWordsProvider("\\stopwords.txt")

        val expectedStopWords = setOf("the", "a", "of", "on")
        val actualStopWords = stopWordsProvider.getStopWords()
        Assert.assertEquals(expectedStopWords, actualStopWords)
    }
}