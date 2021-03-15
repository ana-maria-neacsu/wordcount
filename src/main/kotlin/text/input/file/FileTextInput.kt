package text.input.file

import text.input.api.TextInput
import java.io.File

class FileTextInput(
    private val path: String
) : TextInput {

    override fun getText() = File(path).readText()
}