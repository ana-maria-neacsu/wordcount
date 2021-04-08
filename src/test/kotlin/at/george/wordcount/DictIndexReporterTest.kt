package at.george.wordcount

import at.george.wordcount.myMocks.TestConsole
import org.junit.jupiter.api.Test

class DictIndexReporterTest {
    private val console = TestConsole()
    private val indexReporter = DictIndexReporter(
            console = console,
            dictionaryWords = listOf("has", "lamb")
    )

    @Test
    fun `dict index reporter reports correct index`() {
        val uniqueWords = listOf("Marry", "has")
        indexReporter.report(uniqueWords)

        console.assertPrintedLines("Index (unknown: 1):", "Marry*", "has")
    }

    @Test
    fun `dict index reporter reports correct index when no words`() {
        val uniqueWords = emptyList<String>()
        indexReporter.report(uniqueWords)

        console.assertPrintedLines("Index (unknown: 0):")
    }
}