package at.george.wordcount

class WordCounter {

    fun count(words: List<String>, exceptions: List<String>): CountResult {
        val uniquesWords = words.filter { !exceptions.contains(it) }
        val distinctWords = uniquesWords.distinct()

        return CountResult(uniquesWords.count(), distinctWords.count())
    }
}

data class CountResult(val numberOfWords: Int, val numberOfUniqueWords: Int)
