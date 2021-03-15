package token.count.api

interface TokensCountUseCase {

    fun countTokens(tokens: List<String>): Int
}