fun main() {
    val stopWordsProvider = ResourceFileStopWordsProvider(STOPWORDS_FILE_PATH)
    val latinWordCounter = LatinWordCounter(stopWordsProvider)

    print("Enter text: ")
    val inputText = readLine()

    val wordsCount = latinWordCounter.count(inputText!!)

    println("Number of words: $wordsCount")
}

private const val STOPWORDS_FILE_PATH = "\\stopwords.txt"