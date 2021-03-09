interface WordCounter
{
    fun count(text: String): Int
}

class LatinWordCounter : WordCounter
{
    override fun count(text: String): Int {
        val tokens = text.split(' ')

        return tokens.count { token ->
            val containsInvalidCharacter = token.contains(INVALID_CHARACTER_REGEX)
            !containsInvalidCharacter && token.isNotEmpty()
        }
    }

    companion object {
        private val INVALID_CHARACTER_REGEX = Regex("[^a-zA-Z]")
    }
}