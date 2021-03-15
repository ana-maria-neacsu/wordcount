package domain.impl

import domain.StopWordsGetUseCase
import domain.TokensFilterUseCase

class NonStopWordTokensFilterUseCase(
    private val stopWordsGetUseCase: StopWordsGetUseCase
) : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.filterNot { stopWordsGetUseCase.getStopWords().contains(it) }
}