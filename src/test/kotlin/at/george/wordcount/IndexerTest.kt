package at.george.wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IndexerTest {
    private val indexer = Indexer()

    @Test
    fun `should index words according to dictionary`() {
        val words = listOf("Marry", "has", "a", "lamb")
        val dictionary = listOf("has", "other", "lamb")
        val indexedWords = indexer.index(words, dictionary)

        assertEquals(4, indexedWords.size)
        assertEquals(
                listOf(
                        IndexedWord(word = "Marry"),
                        IndexedWord(word = "has", isKnown = true),
                        IndexedWord(word = "a"),
                        IndexedWord(word = "lamb", isKnown = true)
                ), indexedWords
        )
    }
}