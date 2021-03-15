package domain.impl

import domain.TokensFilterUseCase

class NonStopWordTokensFilterUseCase(
    private val stopWords: List<String>
) : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.filterNot { stopWords.contains(it) }
}