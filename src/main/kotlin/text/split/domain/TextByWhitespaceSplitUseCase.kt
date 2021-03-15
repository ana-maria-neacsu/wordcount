package text.split.domain

import text.split.api.TextSplitUseCase

class TextByWhitespaceSplitUseCase: TextSplitUseCase {

    override fun split(text: String) = text.split("\\s+".toRegex())
}