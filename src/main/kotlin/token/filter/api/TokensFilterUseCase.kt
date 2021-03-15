package token.filter.api

interface TokensFilterUseCase {

    fun filter(tokens: List<String>): List<String>
}