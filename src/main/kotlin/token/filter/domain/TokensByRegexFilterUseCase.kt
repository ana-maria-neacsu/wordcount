package token.filter.domain

import token.filter.api.TokensFilterUseCase

class TokensByRegexFilterUseCase(
    private val regex: Regex
) : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.filter { it.matches(regex) }
}