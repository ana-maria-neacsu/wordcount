package text.split.domain

import text.split.api.TextSplitUseCase

class TextByDashSplitUseCase : TextSplitUseCase {

    override fun split(text: String) = text.split("-+".toRegex())
}