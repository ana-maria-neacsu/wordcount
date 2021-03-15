package domain

class ValidWordsCountUseCase(
    private val textSplitUseCase: TextSplitUseCase,
    private val tokensFilterUseCase: TokensFilterUseCase
) : WordsCountUseCase {

    override fun countWords(text: String) = tokensFilterUseCase.filter(
        textSplitUseCase.split(text)
    ).count()
}