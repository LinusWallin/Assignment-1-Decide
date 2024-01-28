import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    void dummyTest(){
        assertEquals(1,2-1);
    }

    @Test
    void dummyTestWrong(){
        assertEquals(1, 2);
    }
}
