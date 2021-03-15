package domain

interface TextSplitUseCase {

    fun split(text: String): List<String>
}