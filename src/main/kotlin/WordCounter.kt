interface WordCounter {
    fun count(text: String, dictionary: Set<String>): WordCount
}

class LatinWordCounter(
        stopWordsProvider: StopWordsProvider? = null
) : WordCounter {
    private val stopWords: Set<String> = stopWordsProvider?.getStopWords() ?: emptySet()

    override fun count(text: String, dictionary: Set<String>): WordCount {
        val tokens = text.split(SEPARATOR_CHARACTER_REGEX)

        val words = tokens.filter { token ->
            val containsInvalidCharacter = token.contains(INVALID_CHARACTER_REGEX)
            !containsInvalidCharacter && token.isNotEmpty() && stopWords.none { stopWord -> stopWord.compareTo(token, true) == 0 }
        }

        return WordCount(
                words.size,
                words.map { it.toLowerCase() }.distinct().size,
                if (words.isNotEmpty()) words.sumBy { it.length }.toDouble() / words.size else 0.0,
                words.map { it.toLowerCase() to it }.toMap().values
                        .sortedWith { first, second -> first.compareTo(second, true)}
                        .map { word -> WordFromIndex(word, dictionary.none { wordFromDictionary -> wordFromDictionary.compareTo(word, true) == 0 }) }
        )
    }

    companion object {
        private val INVALID_CHARACTER_REGEX = Regex("[^a-zA-Z-]")
        private val SEPARATOR_CHARACTER_REGEX = Regex("([#?!@\$%^&*., \t\n\r])")
    }
}

data class WordCount(
        val total: Int,
        val unique: Int,
        val avgLength: Double,
        val index: List<WordFromIndex> = emptyList()
)

data class WordFromIndex(
        val word: String,
        val unknown: Boolean = false
) {
    override fun toString(): String {
        return word + (if (unknown) "*" else "")
    }
}