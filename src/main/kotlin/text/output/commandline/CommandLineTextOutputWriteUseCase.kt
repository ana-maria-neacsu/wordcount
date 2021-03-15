package text.output.commandline

import text.output.api.TextOutputWriteUseCase

class CommandLineTextOutputWriteUseCase : TextOutputWriteUseCase {

    override fun writeText(text: String) = kotlin.io.print(text)
}