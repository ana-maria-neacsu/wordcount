package text.split.api

interface TextSplitUseCase {

    fun split(text: String): List<String>
}