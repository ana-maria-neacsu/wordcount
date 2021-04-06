package at.george.wordcount

import java.io.File

fun main() {
    val stopwordsFile =  File("stopwords.txt")
    val exceptionWords = WordReader().readFromFile(stopwordsFile)

    print("Enter text: ")
    val text = readLine()

    val wordCounter = WordCounter()
    val numberOfWords = wordCounter.count(text, exceptionWords)

    println("Number of words: $numberOfWords")
}