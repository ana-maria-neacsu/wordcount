package at.george.wordcount

import java.io.File

class WordReader {

    fun readFromFile(file: File): List<String> {
        return if (file.isFile)
            file.readLines().flatMap { it.trim().split(" ") }
        else emptyList()
    }

    fun readFromLine(line: String?): List<String>{
        return line?.trim()?.split(" ") ?: emptyList()
    }
}
