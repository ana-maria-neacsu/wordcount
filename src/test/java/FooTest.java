import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {
    @Test
    public void testFooMethod(){
        int testInt = 1;
        Assertions.assertEquals(1, testInt);
    }
}
