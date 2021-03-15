package token.filter.domain

import token.filter.api.TokensFilterUseCase

class CompositeTokensFilterUseCase(
    private val filters: List<TokensFilterUseCase>
) : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = filters.foldRight(tokens) { filter, newTokens ->
        filter.filter(newTokens)
    }
}