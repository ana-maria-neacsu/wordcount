package stopwords.api

interface StopWordsGetUseCase {

    fun getStopWords(): List<String>
}