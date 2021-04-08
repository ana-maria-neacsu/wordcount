package at.george.wordcount

class Indexer {

    fun index(uniqueWords: List<String>, dictionary: List<String>): List<IndexedWord> =
            uniqueWords.map { IndexedWord(it, dictionary.contains(it)) }
}

data class IndexedWord(val word: String, val isKnown: Boolean = false)