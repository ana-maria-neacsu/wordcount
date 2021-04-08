package at.george.wordcount

class WordCounter {

    fun count(words: List<String>, exceptions: List<String> = emptyList()): CountResult {
        val allowedWords = words.filter { !exceptions.contains(it) }
        val distinctWords = allowedWords.distinct()

        return CountResult(
                numberOfWords = allowedWords.count(),
                uniqueWords = distinctWords,
                avgWordLength = distinctWords.map { it.length }.average()
        )
    }
}

data class CountResult(
        val numberOfWords: Int,
        val uniqueWords: List<String>,
        val avgWordLength: Double
)
