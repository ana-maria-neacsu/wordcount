package text.split.domain

import text.split.api.TextSplitUseCase

class CompositeTextSplitUseCase(
    private val splitUseCases: List<TextSplitUseCase>
): TextSplitUseCase {

    override fun split(text: String) = splitUseCases.foldRight(listOf(text)) { splitUseCase, tokens ->
        tokens.flatMap { splitUseCase.split(it) }
    }.filter { it.isNotBlank() }
}