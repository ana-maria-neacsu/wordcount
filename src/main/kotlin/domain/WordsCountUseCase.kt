package domain

interface WordsCountUseCase {

    fun countWords(text: String): Int
}