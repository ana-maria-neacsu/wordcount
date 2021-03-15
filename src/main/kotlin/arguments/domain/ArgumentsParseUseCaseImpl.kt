package arguments.domain

import arguments.api.Arguments
import arguments.api.ArgumentsParseUseCase

class ArgumentsParseUseCaseImpl : ArgumentsParseUseCase {

    override fun parseArguments(args: Array<String>) = Arguments(
        textFilePath = args.getOrNull(0)
    )
}