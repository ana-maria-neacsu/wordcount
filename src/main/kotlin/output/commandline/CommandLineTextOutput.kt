package output.commandline

import output.TextOutput

class CommandLineTextOutput : TextOutput {

    override fun showText(text: String) = kotlin.io.print(text)
}