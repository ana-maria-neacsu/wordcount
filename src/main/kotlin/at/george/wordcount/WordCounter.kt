package at.george.wordcount

class WordCounter {
    fun count(text: String?): Int {
        return text?.trim()?.split(" ")?.filter { it.matches("[a-zA-Z]+".toRegex()) }?.count() ?: 0
    }
}
