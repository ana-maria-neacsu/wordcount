package at.george.wordcount

import java.io.File

fun main(args: Array<String>) {
    val wordReader = WordReader()
    val exceptionWords = wordReader.readFromFile(File("stopwords.txt"))
    val words = if (args.isEmpty()) {
        print("Enter text: ")
        wordReader.readFromLine(readLine())
    } else {
        wordReader.readFromFile(File(args[0]))
    }

    val wordCounter = WordCounter()
    val numberOfWords = wordCounter.count(words, exceptionWords)

    println("Number of words: $numberOfWords")
}