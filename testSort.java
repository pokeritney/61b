/* test the Sort class
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class testSort {

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};

        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 2;
        int actual2 = Sort.findSmallest(input2, 2);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, 0, 2);
        assertArrayEquals(expected, input);
    }

}
