interface WordCounter
{
    fun count(text: String): Int
}

class LatinWordCounter(
        stopWordsProvider: StopWordsProvider? = null
) : WordCounter
{
    private val stopWords: Set<String> = stopWordsProvider?.getStopWords() ?: emptySet()

    override fun count(text: String): Int {
        val tokens = text.split(' ')

        return tokens.count { token ->
            val containsInvalidCharacter = token.contains(INVALID_CHARACTER_REGEX)
            !containsInvalidCharacter && token.isNotEmpty() && stopWords.none { stopWord -> stopWord.compareTo(token, true) == 0 }
        }
    }

    companion object {
        private val INVALID_CHARACTER_REGEX = Regex("[^a-zA-Z]")
    }
}