package at.george.wordcount

interface Console {
    fun prompt(message: String): String
    fun println(message: String)
}

class ConsoleImpl : Console {
    override fun prompt(message: String): String {
        print(message)
        return readLine() ?: ""
    }

    override fun println(message: String) {
        kotlin.io.println(message)
    }
}
