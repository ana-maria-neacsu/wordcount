package domain

interface TokensFilterUseCase {

    fun filter(tokens: List<String>): List<String>
}