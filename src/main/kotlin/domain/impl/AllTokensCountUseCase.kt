package domain.impl

import domain.TokensCountUseCase

class AllTokensCountUseCase : TokensCountUseCase {

    override fun countTokens(tokens: List<String>) = tokens.count()
}