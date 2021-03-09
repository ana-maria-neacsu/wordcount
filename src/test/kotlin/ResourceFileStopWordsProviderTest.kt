import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class ResourceFileStopWordsProviderTest {

    @Test
    @Ignore
    fun `test no resource file is given`()
    {
        val stopWordsProvider = ResourceFileStopWordsProvider("\\notExistingFile.txt")

        val expectedValue = emptySet<String>()
        val actualValue = stopWordsProvider.getStopWords()
        Assert.assertEquals(expectedValue, actualValue)
    }
}