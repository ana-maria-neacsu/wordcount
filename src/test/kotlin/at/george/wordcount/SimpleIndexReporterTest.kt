package at.george.wordcount

import at.george.wordcount.myMocks.TestConsole
import org.junit.jupiter.api.Test

internal class SimpleIndexReporterTest{
    private val console = TestConsole()
    private val indexReporter = SimpleIndexReporter(console = console)

    @Test
    fun `simple index reporter reports correct index`(){
        val uniqueWords = listOf("Marry", "has")
        indexReporter.report(uniqueWords)

        console.assertPrintedLines("Index:\nMarry\nhas")
    }

    @Test
    fun `simple index reporter reports correct index when no words`(){
        val uniqueWords = emptyList<String>()
        indexReporter.report(uniqueWords)

        console.assertPrintedLines("Index:\n")
    }
}