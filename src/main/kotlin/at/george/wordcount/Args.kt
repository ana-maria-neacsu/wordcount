package at.george.wordcount

import java.io.File

data class Args(
        val file: File? = null,
        val printIndex: Boolean = false,
        val dict: File? = null
) {
    companion object {
        fun from(args: Array<String>): Args {
            return Args(
                    file = args.firstOrNull { !it.startsWith("-") }?.let { File(it) },
                    printIndex = args.contains("-index"),
                    dict = args.firstOrNull{ it.startsWith("-dictionary=")}
                            ?.removePrefix("-dictionary=")
                            ?.let { File(it) }
            )
        }
    }
}