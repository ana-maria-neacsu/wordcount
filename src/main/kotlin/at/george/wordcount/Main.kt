package at.george.wordcount

import java.io.File

fun main(args: Array<String>) {
    val parsedArgs = Args.from(args)

    val wordReader = WordReader()
    val exceptionWords = wordReader.readFromFile(File("stopwords.txt"))

    val words = if (parsedArgs.file == null) {
        print("Enter text: ")
        wordReader.readFromLine(readLine() ?: "")
    } else {
        wordReader.readFromFile(parsedArgs.file)
    }

    val wordCounter = WordCounter()
    val countResult = wordCounter.count(words, exceptionWords)

    println("Number of words: ${countResult.numberOfWords}, " +
            "unique: ${countResult.uniqueWords.size}; " +
            "average word length: ${countResult.avgWordLength} characters")

    if(parsedArgs.printIndex) {
        println("Index:\n" +
                countResult.uniqueWords.joinToString(separator = "\n"))
    }

}