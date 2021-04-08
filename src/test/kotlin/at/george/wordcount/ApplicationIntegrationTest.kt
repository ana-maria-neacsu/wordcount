package at.george.wordcount

import at.george.wordcount.myMocks.TestConsole
import org.junit.jupiter.api.Test
import java.io.File

class ApplicationIntegrationTest {

    private val dictionaryFile = resourceFile("/testDictionary.txt")
    private val wordsFile = resourceFile("/testWords.txt")
    private val stopWordsFile = resourceFile("/stopwords.txt")

    private val testConsole = TestConsole()
    private val application = Application(
            console = testConsole,
            stopWordsFile = stopWordsFile,
            wordReader = WordReader(),
            wordCounter = WordCounter(),
            indexer = Indexer()
    )

    @Test
    fun `should print user input words, unique words and avg word length, but no index`() {
        val args = emptyArray<String>()
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters"
        )
    }

    @Test
    fun `should print user input words, unique words and avg word length and the index`() {
        val args = arrayOf("-index")
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Index:\nUser\ntest\ninput\nline"
        )
    }

    @Test
    fun `should print user input words, unique words and avg word length and the index and dictionary`() {
        val args = arrayOf("-index", "-dictionary=$dictionaryFile")
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Index (unknown: 4):",
                "User*",
                "test*",
                "input*",
                "line*"
        )
    }

    @Test
    fun `should use words from file and display together with index and dictionary`() {
        val args = arrayOf("$wordsFile", "-index", "-dictionary=$dictionaryFile")
        application.run(args)

        testConsole.assertPrintedLines(
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Index (unknown: 1):",
                "Mary*",
                "has",
                "little",
                "lamb"
        )
    }

    private fun resourceFile(resource: String) =
            File(ApplicationIntegrationTest::class.java.getResource(resource).file)
}