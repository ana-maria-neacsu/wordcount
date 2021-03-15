package text.input.file

import text.input.api.InvalidInputException
import text.input.api.TextInputReadUseCase
import java.io.File
import java.io.FileNotFoundException

class FileTextInputReadUseCase(
    private val path: String
) : TextInputReadUseCase {

    override fun getText() = try {
        File(path).readText()
    } catch (e: FileNotFoundException) {
        throw InvalidInputException("Invalid input text file path")
    }
}