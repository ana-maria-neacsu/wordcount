package text.input.commandline

import text.input.api.TextInput

class CommandLineTextInput : TextInput {

    override fun getText() = kotlin.io.readLine().orEmpty()
}