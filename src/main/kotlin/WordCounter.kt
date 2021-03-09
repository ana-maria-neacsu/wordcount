interface WordCounter
{
    fun count(text: String): Int
}

class SimpleWordCounter : WordCounter
{
    override fun count(text: String): Int {
        val tokens = text.split(' ')

        return tokens.count { token ->
            val containsInvalidCharacter = token.contains(Regex("[^a-zA-Z]"))
            !containsInvalidCharacter
        }
    }
}