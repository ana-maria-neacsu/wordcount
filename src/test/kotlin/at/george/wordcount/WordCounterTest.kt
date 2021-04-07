package at.george.wordcount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WordCounterTest {
    private val wordCounter = WordCounter()

    @Test
    fun `null text should return 0`() {
        val text = emptyList<String>()
        val result = wordCounter.count(text, emptyList()).numberOfWords

        assertEquals(0, result)
    }

    @Test
    fun `should return right number of words`() {
        val text = listOf("Marry", "had", "a", "little", "lamb")
        val result = wordCounter.count(text, emptyList()).numberOfWords

        assertEquals(5, result)
    }

    @Test
    fun `should not count the words passed as exceptions`() {
        val text = listOf("Marry", "had", "a", "little", "lamb", "the")
        val result = wordCounter.count(text, listOf("on", "off", "the", "a")).numberOfWords

        assertEquals(4, result)
    }

    @Test
    fun `should return the right number of unique words`() {
        val text = listOf("Marry", "had", "a", "little", "lamb", "Marry", "had", "a")
        val result = wordCounter.count(text, listOf("on", "off", "the", "a")).numberOfUniqueWords

        assertEquals(4, result)
    }
}