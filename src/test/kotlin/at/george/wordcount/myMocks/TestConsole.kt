package at.george.wordcount.myMocks

import at.george.wordcount.Console
import org.junit.jupiter.api.Assertions.assertEquals

class TestConsole : Console {
    private val msgStack = mutableListOf<String>()
    private val responseStack = mutableListOf<String>()

    override fun prompt(message: String): String? {
        msgStack.add(message)
        return responseStack.removeFirst()
    }

    override fun println(message: String) {
        msgStack.add(message)
    }

    fun assertPrintedLines(vararg lines: String) {
        assertEquals(lines.toList(), msgStack)
    }

    fun prepareResponse(lines: MutableList<String>) {
        responseStack.clear()
        responseStack.addAll(lines)
    }
}