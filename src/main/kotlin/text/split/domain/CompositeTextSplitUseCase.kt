package text.split.domain

import text.split.api.TextSplitUseCase

class CompositeTextSplitUseCase(
    private val splitUseCases: List<TextSplitUseCase>
): TextSplitUseCase {

    override fun split(text: String): List<String> {
        TODO("Not yet implemented")
    }
}