package text.input.commandline

import text.input.api.TextInputReadUseCase

class CommandLineTextInputReadUseCase : TextInputReadUseCase {

    override fun getText() = kotlin.io.readLine().orEmpty()
}