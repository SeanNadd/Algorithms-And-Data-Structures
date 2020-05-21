package recursions;

import org.junit.Before;
import org.junit.Test;
import recursions.impl.RecursionImpl;

import static org.junit.Assert.assertEquals;

public class RecursionTest {
    private int[] values;
    private Recursion recursion;

    @Before
    public void setUp() throws Exception {
        recursion = new RecursionImpl();
        values=  new int[]{3,9,6,4,5,2,1,8,7,10};
    }

    @Test
    public void testFindLargestNumber() {
        int largest = recursion.findLargestNumber(values, 0, values.length -1);
        assertEquals("Testing devide and conquer for largest number on array", 10, largest);
    }
}
