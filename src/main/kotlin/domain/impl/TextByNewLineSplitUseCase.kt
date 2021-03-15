package domain.impl

import domain.TextSplitUseCase

class TextByNewLineSplitUseCase : TextSplitUseCase {

    override fun split(text: String) = text.lines()
}