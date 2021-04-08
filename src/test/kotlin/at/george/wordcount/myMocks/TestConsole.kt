package at.george.wordcount.myMocks

import at.george.wordcount.Console
import org.junit.jupiter.api.Assertions.assertEquals

class TestConsole : Console {
    private val msgStack = mutableListOf<String>()

    override fun prompt(message: String): String {
        msgStack.add(message)
        return "User test input line"
    }

    override fun println(message: String) {
        msgStack.add(message)
    }

    fun assertPrintedLines(vararg lines: String) {
        assertEquals(lines.toList(), msgStack)
    }
}