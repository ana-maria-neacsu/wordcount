package word.count.domain

import text.split.api.TextSplitUseCase
import token.count.api.TokensCountUseCase
import token.filter.api.TokensFilterUseCase
import word.count.api.WordsCountGetUseCase

class ConfigurableWordsCountGetUseCase(
    private val textSplitUseCase: TextSplitUseCase,
    private val tokensFilterUseCase: TokensFilterUseCase,
    private val tokensCountUseCase: TokensCountUseCase
) : WordsCountGetUseCase {

    override fun getWordCount(text: String) = tokensCountUseCase.countTokens(
        tokensFilterUseCase.filter(
            textSplitUseCase.split(text)
        )
    )
}