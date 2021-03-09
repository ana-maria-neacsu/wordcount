interface StopWordsProvider{
    fun getStopWords(): Set<String>
}

class ResourceFileStopWordsProvider(
        private val resourceFilePath: String
) : StopWordsProvider {

    override fun getStopWords(): Set<String> {
        return LatinWordCounter::class.java.getResource(resourceFilePath).readText().split(NEW_LINE_REGEX).toSet()
    }

    companion object {
        private const val STOP_WORDS_FILE_PATH = "/stopwords.txt"
        private val NEW_LINE_REGEX = Regex("(\\r\\n|\\r|\\n)")
    }
}