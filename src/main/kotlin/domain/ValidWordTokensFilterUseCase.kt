package domain

class ValidWordTokensFilterUseCase : TokensFilterUseCase {

    override fun filter(tokens: List<String>) = tokens.filter { it.matches("[a-zA-Z]+".toRegex()) }
}