package text.split.domain

import text.split.api.TextSplitUseCase

class TextByNewLineSplitUseCase : TextSplitUseCase {

    override fun split(text: String) = text.lines().filter { it.isNotBlank() }
}