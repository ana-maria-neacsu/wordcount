package at.george.wordcount

fun main() {
    print("Enter text: ")
    val text = readLine()

    val wordCounter = WordCounter()
    val numberOfWords = wordCounter.count(text)

    println("Number of words: $numberOfWords")
}