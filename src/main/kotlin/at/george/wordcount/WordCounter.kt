package at.george.wordcount

class WordCounter {
    fun count(text: String?, exceptions: List<String>): Int {
        return text?.trim()?.split(" ")?.
        filter { it.matches("[a-zA-Z]+".toRegex()) }?.
        filter { !exceptions.contains(it) }?.
        count() ?: 0
    }
}
