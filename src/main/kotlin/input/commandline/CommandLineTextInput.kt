package input.commandline

import input.TextInput

class CommandLineTextInput : TextInput {

    override fun getText() = kotlin.io.readLine().orEmpty()
}