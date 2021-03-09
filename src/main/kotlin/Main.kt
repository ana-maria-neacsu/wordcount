import java.io.File

fun main(vararg args: String) {
    var inputText = ""
    var fileExists = false
    if (args.isNotEmpty())
    {
        val inputFile = File(args[0])
        if (inputFile.exists())
        {
            fileExists = true
            inputText = inputFile.readText()
        }
    }

    if (!fileExists)
    {
        print("Enter text: ")
        inputText = readLine()!!
    }

    val stopWordsProvider = ResourceFileStopWordsProvider(STOPWORDS_FILE_PATH)
    val latinWordCounter = LatinWordCounter(stopWordsProvider)

    val wordsCount = latinWordCounter.count(inputText)

    println("Number of words: $wordsCount")
}

private const val STOPWORDS_FILE_PATH = "\\stopwords.txt"