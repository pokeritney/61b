import org.junit.Test;

import static org.junit.Assert.*;

public class FlikTest {

    /** Performs a few arbitrary tests to see if the product method is correct */

    @Test 
    public void testSame() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.
        */

        assertTrue(Flik.isSameNumber(2, 2));
        assertTrue(Flik.isSameNumber(100, 100));
        assertFalse(Flik.isSameNumber(1, 2));
    }

    /* Run the unit tests in this file. */
    public static void main(String... args) {        
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}
