package application

import org.junit.Assert
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class ApplicationTest {
    @Test
    fun `test a simple mytexttxt file with four words as an argument for application`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream)
        val filePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/mytext.txt").path

        application.run(filePath)

        val expectedOutput = generateOutput("Number of words: 4, unique: 4; average word length: 4.25 characters")
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test an empty file as an argument`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream)
        val filePath = ApplicationTest::class.java.getResource("/emptyFile.txt").path

        application.run(filePath)

        val expectedOutput = generateOutput("Number of words: 0, unique: 0; average word length: 0.00 characters")
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test no argument is provided`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "1Foo Ba3r.           Word")

        application.run()

        val expectedOutput = generateOutput("Number of words: 1, unique: 1; average word length: 4.00 characters")
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test no file exists, asks for manual input`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "word")

        application.run("nonexistingpath")

        val expectedOutput = generateOutput("Number of words: 1, unique: 1; average word length: 4.00 characters")
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test manual input with duplicated words`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        application.run()

        val expectedOutput = generateOutput("Number of words: 7, unique: 6; average word length: 6.43 characters")
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test manual input with duplicated words and index specified`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")
        val index = listOf("Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty", "had", "great", "fall")

        application.run("-index")

        val expectedOutput = generateOutput("Number of words: 7, unique: 6; average word length: 6.43 characters", index)
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test a simple mytexttxt file with four words as an argument for application and index for output`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream)
        val index = listOf("Mary", "had", "little", "lamb")
        val filePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/mytext.txt").path

        application.run("-index", filePath)

        val expectedOutput = generateOutput("Number of words: 4, unique: 4; average word length: 4.25 characters", index)
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test an empty text with index specified`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, " ")
        val index = emptyList<String>()

        application.run("-index")

        val expectedOutput = generateOutput("Number of words: 0, unique: 0; average word length: 0.00 characters", index)
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test line feed is interrupted by EOF`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "")

        application.run()

        val expectedOutput = "Please, do not interrupt a line feed with EOF symbol...${System.lineSeparator()}"
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    private fun generateOutput(mainOutputLine: String, indexList: List<String>? = null): String {
        return "$mainOutputLine${System.lineSeparator()}" +
                (indexList?.joinToString(
                        System.lineSeparator(),
                        prefix = "Index:${System.lineSeparator()}",
                        postfix = if (indexList.isNotEmpty()) System.lineSeparator() else ""
                ) ?: "")
    }

    private fun createApplication(outputStream: OutputStream, input: String = ""): Application {
        return Application(input.byteInputStream(), PrintStream(outputStream))
    }
}