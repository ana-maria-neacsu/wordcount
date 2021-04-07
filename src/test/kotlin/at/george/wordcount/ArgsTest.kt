package at.george.wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class ArgsTest {

    @Test
    fun `parse empty args`() {
        assertEquals(Args(null, false), Args.from(emptyArray()))
    }

    @Test
    fun `parse file from args`() {
        assertEquals(Args(file = File("myFile.txt")), Args.from(arrayOf("myFile.txt")))
    }

    @Test
    fun `parse index from args`() {
        assertEquals(Args(printIndex = true), Args.from(arrayOf("-index")))
    }

    @Test
    fun `parse file and index from args`() {
        assertEquals(
                Args(file = File("myFile.txt"), printIndex = true),
                Args.from(arrayOf("myFile.txt", "-index"))
        )
    }

    @Test
    fun `parse file and index from args independent of order`() {
        assertEquals(
                Args(file = File("myFile.txt"), printIndex = true),
                Args.from(arrayOf("-index", "myFile.txt"))
        )
    }
}