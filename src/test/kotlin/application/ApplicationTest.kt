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

        val expectedOutput = generateOutput(
                "Number of words: 1, unique: 1; average word length: 4.00 characters",
                true,
                lastManualInput = true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test no file exists, asks for manual input`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "word")

        application.run("nonexistingpath")

        val expectedOutput = generateOutput(
                "Number of words: 1, unique: 1; average word length: 4.00 characters",
                true,
                lastManualInput = true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test manual input with duplicated words`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        application.run()

        val expectedOutput = generateOutput(
                "Number of words: 7, unique: 6; average word length: 6.43 characters",
                true,
                lastManualInput = true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test manual input with duplicated words and index specified`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")
        val index = listOf("fall", "great", "had", "Humpty-Dumpty*", "sat", "wall")
        val dictionaryFilePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/dictionary1.txt").path

        application.run("-index", "-dictionary=\"$dictionaryFilePath\"")

        val expectedOutput = generateOutput(
                "Number of words: 7, unique: 6; average word length: 6.43 characters",
                true,
                1,
                index,
                true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test part of words are being in the dictionary`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, "Mary had a little lamb")
        val index = listOf("had", "lamb*", "little", "Mary*")
        val dictionaryFilePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/dictionary2.txt").path

        application.run("-index", "-dictionary=\"$dictionaryFilePath\"")

        val expectedOutput = generateOutput(
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                true,
                2,
                index,
                true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test a simple mytexttxt file with four words as an argument for application and index for output`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream)
        val index = listOf("had*", "lamb*", "little*", "Mary*")
        val textFilePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/mytext.txt").path
        val dictionaryFilePath = ApplicationTest::class.java.getResource("/ApplicationInputFiles/emptyDictionary.txt").path

        application.run("-index", "-dictionary=\"$dictionaryFilePath\"", textFilePath)

        val expectedOutput = generateOutput(
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                false,
                4,
                index
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `test an empty text with index specified`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, " ")
        val index = emptyList<String>()

        application.run("-index")

        val expectedOutput = generateOutput(
                "Number of words: 0, unique: 0; average word length: 0.00 characters",
                true,
                0,
                index,
                true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    //It wouldn't hurt to add one more test for multiple manual inputs with index included
    fun `test multiple manual inputs are provided`() {
        val outputStream = ByteArrayOutputStream()
        val application = createApplication(outputStream, listOf("Mary had a little lamb", "a bb ccc dddd", "").joinToString(System.lineSeparator()))

        application.run()

        val expectedOutputLine1 = generateOutput(
                "Number of words: 4, unique: 4; average word length: 4.25 characters",
                true,
                0,
        )
        val expectedOutputLine2 = generateOutput(
                "Number of words: 3, unique: 3; average word length: 3.00 characters",
                true,
                0,
                lastManualInput = true
        )
        val actualOutput = String(outputStream.toByteArray())
        Assert.assertEquals(expectedOutputLine1 + expectedOutputLine2, actualOutput)
    }

    private fun generateOutput(
            mainOutputLine: String,
            manualInput: Boolean = false,
            unknownWordsCounter: Int = 0,
            indexList: List<String>? = null,
            lastManualInput: Boolean = false
    ): String {
        return (if (manualInput) "Enter text: " else "") +
                "$mainOutputLine${System.lineSeparator()}" +
                (indexList?.joinToString(
                        System.lineSeparator(),
                        prefix = "Index (unknown $unknownWordsCounter):${System.lineSeparator()}",
                        postfix = if (indexList.isNotEmpty()) System.lineSeparator() else ""
                ) ?: "") +
                if (lastManualInput) "Enter text: " else ""
    }

    private fun createApplication(outputStream: OutputStream, input: String = ""): Application {
        return Application(input.byteInputStream(), PrintStream(outputStream))
    }
}