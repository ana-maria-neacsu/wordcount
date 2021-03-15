package domain.impl

import domain.TextSplitUseCase
import domain.TokensCountUseCase
import domain.TokensFilterUseCase
import domain.WordsCountGetUseCase

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