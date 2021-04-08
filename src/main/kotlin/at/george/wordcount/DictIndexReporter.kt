package at.george.wordcount

interface IndexReporter {
    fun report(uniqueWords: List<String>)

    interface Factory {
        fun create(args: Args): IndexReporter
    }
}

class NullIndexReporter : IndexReporter {
    override fun report(uniqueWords: List<String>) {
    }
}

class SimpleIndexReporter(
        private val console: Console
) : IndexReporter {
    override fun report(uniqueWords: List<String>) =
            console.println("Index:\n" +
                    uniqueWords.joinToString(separator = "\n"))
}

class DictIndexReporter(
        private val dictionaryWords: List<String>,
        private val console: Console
) : IndexReporter {

    override fun report(uniqueWords: List<String>) {
        val indexerWords = index(uniqueWords)
        val unknownCount = indexerWords.count { !it.isKnown }

        console.println("Index (unknown: $unknownCount):")
        indexerWords.forEach {
            if (!it.isKnown) console.println("${it.word}*") else console.println(it.word)
        }
    }

    private fun index(uniqueWords: List<String>): List<IndexedWord> =
            uniqueWords.map { IndexedWord(it, dictionaryWords.contains(it)) }

}

data class IndexedWord(val word: String, val isKnown: Boolean = false)

class IndexReporterFactory(
        private val wordReader: WordReader,
        private val console: Console
) : IndexReporter.Factory {

    override fun create(args: Args): IndexReporter {
        return if (args.printIndex) {
            if (args.dict == null) {
                SimpleIndexReporter(console)
            } else {
                DictIndexReporter(wordReader.readFromFile(args.dict), console)
            }
        } else {
            NullIndexReporter()
        }
    }
}
