package arguments.domain

import arguments.api.Arguments
import arguments.api.ArgumentsParseUseCase

class DefaultArgumentsParseUseCase : ArgumentsParseUseCase {

    override fun parseArguments(args: Array<String>) = Arguments(
        textFilePath = args.getOrNull(0)
    )
}