import org.junit.Ignore
import org.junit.Test

class FileInputTest
{
    @Test
    @Ignore
    fun `test a simple mytexttxt file with four words as an argument for application`() {
        val filePath = FileInputTest::class.java.getResource("\\ApplicationInputFiles\\mytext.txt").path
        main(filePath)
    }

}