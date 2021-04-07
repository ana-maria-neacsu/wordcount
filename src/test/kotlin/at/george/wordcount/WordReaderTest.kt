package at.george.wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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
    fun `returns the right words when one on line`() {
        val file = File.createTempFile("tmp", "").apply {
            deleteOnExit()
        }
        file.writeText("on\nthe\noff")

        val result = wordReader.readFromFile(file)

        assertEquals(3, result.size)
        assertEquals("on", result[0])
        assertEquals("the", result[1])
        assertEquals("off", result[2])
    }

    @Test
    fun `returns the right words when multiple words on line`() {
        val file = File.createTempFile("tmp", "").apply {
            deleteOnExit()
        }
        file.writeText("Mary has\na little\nlamb")

        val result = wordReader.readFromFile(file)

        assertEquals(5, result.size)
        assertEquals("Mary", result[0])
        assertEquals("has", result[1])
        assertEquals("a", result[2])
        assertEquals("little", result[3])
        assertEquals("lamb", result[4])
    }

    @Test
    fun `read from line should return  words`(){
        val result = wordReader.readFromLine(null)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `read from line should return all words`(){
        val result = wordReader.readFromLine("Mary has a\n")

        assertEquals(3, result.size)
        assertEquals("Mary", result[0])
        assertEquals("has", result[1])
        assertEquals("a", result[2])
    }
}