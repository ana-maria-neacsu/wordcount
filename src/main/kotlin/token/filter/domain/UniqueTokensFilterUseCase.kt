package token.filter.domain

import token.filter.api.TokensFilterUseCase

class UniqueTokensFilterUseCase : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.distinct()
}