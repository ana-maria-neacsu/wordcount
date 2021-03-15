package input.file

import input.TextInput
import java.io.File

class FileTextInput(
    private val path: String
) : TextInput {

    override fun getText() = File(path).readText()
}