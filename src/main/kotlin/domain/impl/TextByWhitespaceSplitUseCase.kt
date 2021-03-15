package domain.impl

import domain.TextSplitUseCase

class TextByWhitespaceSplitUseCase: TextSplitUseCase {

    override fun split(text: String) = text.split("\\s+".toRegex())
}