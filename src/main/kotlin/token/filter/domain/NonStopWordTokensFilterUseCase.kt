package token.filter.domain

import stopwords.api.StopWordsGetUseCase
import token.filter.api.TokensFilterUseCase

class NonStopWordTokensFilterUseCase(
    private val stopWordsGetUseCase: StopWordsGetUseCase
) : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.filterNot { stopWordsGetUseCase.getStopWords().contains(it) }
}