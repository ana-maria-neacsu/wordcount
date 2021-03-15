package token.count.domain

import token.count.api.TokensCountUseCase

class AllTokensCountUseCase : TokensCountUseCase {

    override fun countTokens(tokens: List<String>) = tokens.count()
}