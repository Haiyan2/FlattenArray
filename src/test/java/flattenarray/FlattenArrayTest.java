
package flattenarray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Haiyan
 *
 */
public class FlattenArrayTest {

    /**
     * Test method for
     * {@link flattenarray.FlattenArray#flattenArray(java.lang.Object[])}.
     */
    @Test
    public void testFlattenArray() {
        // Empty input
        Assert.assertArrayEquals(new Integer[0], FlattenArray.flattenArray(new Object[0]));

        // Input with nested arrays: [[1,2,[3]],4]
        Object[] inputs = new Object[] { new Object[] { 1, 2, new Object[] { 3 } }, 4 };

        Integer[] results = FlattenArray.flattenArray(inputs);

        Integer[] expectedResults = { 1, 2, 3, 4 };

        Assert.assertArrayEquals(expectedResults, results);
    }

}
