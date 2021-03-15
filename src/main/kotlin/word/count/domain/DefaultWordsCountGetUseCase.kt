package word.count.domain

import text.split.api.TextSplitUseCase
import token.filter.api.TokensFilterUseCase
import word.count.api.WordsCountGetUseCase

class DefaultWordsCountGetUseCase(
    private val textSplitUseCase: TextSplitUseCase,
    private val tokensFilterUseCase: TokensFilterUseCase
) : WordsCountGetUseCase {

    override fun getWordCount(text: String) = tokensFilterUseCase.filter(
        textSplitUseCase.split(text)
    ).count()
}