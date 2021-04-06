package at.george.wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class WordReaderTest {

    private val wordReader = WordReader()

    @Test
    fun `returns the right number of words in the file`() {
        val file = File.createTempFile("tmp", "").apply {
            deleteOnExit()
        }
        file.writeText("on\nthe\noff")

        val result = wordReader.readFromFile(file)

        assertEquals(3, result.size)
    }

    @Test
    fun `returns the right words in the file`() {
        val file = File.createTempFile("tmp", "").apply {
            deleteOnExit()
        }
        file.writeText("on\nthe\noff")

        val result = wordReader.readFromFile(file)

        assertEquals("on", result[0])
        assertEquals("the", result[1])
        assertEquals("off", result[2])
    }
}