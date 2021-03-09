import java.lang.RuntimeException

interface StopWordsProvider {
    fun getStopWords(): Set<String>
}

class ResourceFileStopWordsProvider(
        private val resourceFilePath: String
) : StopWordsProvider {

    override fun getStopWords(): Set<String> {
        val stopWordsResource = LatinWordCounter::class.java.getResource(resourceFilePath)
                ?: throw NoResourceFileWithStopWordsFound()
        return stopWordsResource.readText()
                .split(NEW_LINE_REGEX)
                .filter { it.isNotEmpty() }
                .map { it.toLowerCase() }
                .toSet()
    }

    companion object {
        private val NEW_LINE_REGEX = Regex("(\\r\\n|\\r|\\n)")
    }
}

class NoResourceFileWithStopWordsFound : RuntimeException()