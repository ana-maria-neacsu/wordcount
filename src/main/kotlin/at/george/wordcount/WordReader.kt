package at.george.wordcount

import java.io.File

class WordReader {

    fun readFromFile(file: File): List<String> =
            if (file.isFile) {
                file.readLines().flatMap { readFromLine(it) }
            } else {
                emptyList()
            }

    fun readFromLine(line: String) =
            "[a-zA-Z-']+".toRegex()
                    .findAll(line)
                    .map { it.value }
                    .toList()
}
