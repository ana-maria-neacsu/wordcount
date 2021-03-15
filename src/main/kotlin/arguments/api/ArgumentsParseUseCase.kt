package arguments.api

interface ArgumentsParseUseCase {

    fun parseArguments(args: Array<String>): Arguments
}