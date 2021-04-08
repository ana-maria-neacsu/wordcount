package at.george.wordcount

import at.george.wordcount.myMocks.TestConsole
import org.junit.jupiter.api.Test
import java.io.File

class ApplicationIntegrationTest {

    private val dictionaryFile = resourceFile("/testDictionary.txt")
    private val wordsFile = resourceFile("/testWords.txt")
    private val stopWordsFile = resourceFile("/stopwords.txt")

    private val testConsole = TestConsole()
    private val wordReader = WordReader()

    private val application = Application(
            console = testConsole,
            stopWordsFile = stopWordsFile,
            wordReader = wordReader,
            wordCounter = WordCounter(),
            indexReporterFactory = IndexReporterFactory(
                    wordReader = wordReader,
                    console = testConsole
            )
    )

    @Test
    fun `should print user input words, unique words and avg word length, but no index`() {
        val args = emptyArray<String>()
        testConsole.prepareResponse(mutableListOf("User test input line", ""))
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Enter text: "
        )
    }

    @Test
    fun `should print user input words, unique words and avg word length and the index`() {
        val args = arrayOf("-index")
        testConsole.prepareResponse(mutableListOf("User test input line", ""))
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Index:\nUser\ntest\ninput\nline",
                "Enter text: "
        )
    }

    @Test
    fun `should print user input words, unique words and avg word length and the index and dictionary`() {
        val args = arrayOf("-index", "-dictionary=$dictionaryFile")
        testConsole.prepareResponse(mutableListOf("User test input line", ""))
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Index (unknown: 4):",
                "User*",
                "test*",
                "input*",
                "line*",
                "Enter text: "
        )
    }

    @Test
    fun `should use words from file and display together with index and dictionary`() {
        val args = arrayOf("$wordsFile", "-index", "-dictionary=$dictionaryFile")
        testConsole.prepareResponse(mutableListOf("User test input line", ""))
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

    @Test
    fun `user should be allowed to enter several texts`() {
        val args = emptyArray<String>()
        testConsole.prepareResponse(mutableListOf("User test input line", "Mary has a little lamb", ""))
        application.run(args)

        testConsole.assertPrintedLines(
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Enter text: ",
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                "Enter text: "
        )
    }

    private fun resourceFile(resource: String) =
            File(ApplicationIntegrationTest::class.java.getResource(resource).file)
}