package at.george.wordcount

class WordCounter {

    fun count(words: List<String>, exceptions: List<String> = emptyList()): CountResult {
        val uniquesWords = words.filter { !exceptions.contains(it) }
        val distinctWords = uniquesWords.distinct()

        return CountResult(
                numberOfWords = uniquesWords.count(),
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
