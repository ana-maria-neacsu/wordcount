package at.george.wordcount

import java.io.File

class WordReader {

    fun readFromFile(stopwordsFile: File): List<String> {
        return if (stopwordsFile.isFile) stopwordsFile.readLines() else emptyList()
    }
}
