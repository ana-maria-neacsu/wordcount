package at.george.wordcount

class WordCounter {
    fun count(words: List<String>, exceptions: List<String>): Int {
        return words.filter { it.matches("[a-zA-Z]+".toRegex()) }.
        filter { !exceptions.contains(it) }.
        count()
    }
}
