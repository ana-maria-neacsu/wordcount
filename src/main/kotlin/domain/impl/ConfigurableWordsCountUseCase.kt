package domain.impl

import domain.TextSplitUseCase
import domain.TokensCountUseCase
import domain.TokensFilterUseCase
import domain.WordsCountUseCase

class ConfigurableWordsCountUseCase(
    private val textSplitUseCase: TextSplitUseCase,
    private val tokensFilterUseCase: TokensFilterUseCase,
    private val tokensCountUseCase: TokensCountUseCase
) : WordsCountUseCase {

    override fun countWords(text: String) = tokensCountUseCase.countTokens(
        tokensFilterUseCase.filter(
            textSplitUseCase.split(text)
        )
    )
}