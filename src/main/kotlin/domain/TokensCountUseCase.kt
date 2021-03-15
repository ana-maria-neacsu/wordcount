package domain

interface TokensCountUseCase {

    fun countTokens(tokens: List<String>): Int
}