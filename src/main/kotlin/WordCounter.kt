interface WordCounter {
    fun count(text: String): WordCount
}

class LatinWordCounter(
        stopWordsProvider: StopWordsProvider? = null
) : WordCounter {
    private val stopWords: Set<String> = stopWordsProvider?.getStopWords() ?: emptySet()

    override fun count(text: String): WordCount {
        val tokens = text.split(SEPARATOR_CHARACTER_REGEX)

        val words = tokens.filter { token ->
            val containsInvalidCharacter = token.contains(INVALID_CHARACTER_REGEX)
            !containsInvalidCharacter && token.isNotEmpty() && stopWords.none { stopWord -> stopWord.compareTo(token, true) == 0 }
        }
        return WordCount(words.size, words.map { it.toLowerCase() }.distinct().size )
    }

    companion object {
        private val INVALID_CHARACTER_REGEX = Regex("[^a-zA-Z-]")
        private val SEPARATOR_CHARACTER_REGEX = Regex("([#?!@\$%^&*., \t\n\r])")
    }
}

data class WordCount(
        val total: Int,
        val unique: Int
)