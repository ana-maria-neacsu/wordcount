package domain

interface WordsCountGetUseCase {

    fun getWordCount(text: String): Int
}