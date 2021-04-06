package at.george.wordcount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {

    private val wordCounter = WordCounter()

    @Test
    fun `null text should return 0`() {
        val text = null
        val result = wordCounter.count(text, emptyList())

        assertEquals(0, result)
    }

    @Test
    fun `should return right number of words`() {
        val text = "Marry had a little lamb"
        val result = wordCounter.count(text, emptyList())

        assertEquals(5, result)
    }

    @Test
    fun `should not count words that include signs`() {
        val text = "Marry & had a li(ttle lamb"
        val result = wordCounter.count(text, emptyList())

        assertEquals(4, result)
    }

    @Test
    fun `should not count the words passed into the list`() {
        val text = "Marry had a little lamb and a duck but also the dog"
        val result = wordCounter.count(text, listOf("on", "off", "the", "a"))

        assertEquals(9, result)
    }
}