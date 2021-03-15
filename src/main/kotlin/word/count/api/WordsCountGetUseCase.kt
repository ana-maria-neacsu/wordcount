package word.count.api

interface WordsCountGetUseCase {

    fun getWordCount(text: String): Int
}