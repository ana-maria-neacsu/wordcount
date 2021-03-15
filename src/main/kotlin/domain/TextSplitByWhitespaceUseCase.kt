package domain

class TextSplitByWhitespaceUseCase: TextSplitUseCase {

    override fun split(text: String) = text.split("\\s".toRegex())
}