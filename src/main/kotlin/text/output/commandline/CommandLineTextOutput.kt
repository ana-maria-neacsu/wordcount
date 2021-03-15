package text.output.commandline

import text.output.api.TextOutput

class CommandLineTextOutput : TextOutput {

    override fun showText(text: String) = kotlin.io.print(text)
}