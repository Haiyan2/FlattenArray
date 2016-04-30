package flattenarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class flattens an array of arbitrarily nested arrays of integers into a
 * flat array of integers.
 */
public class FlattenArray {

    final static Logger LOGGER = LoggerFactory.getLogger(FlattenArray.class);

    /**
     * Entry point of the project.
     * 
     * @param args
     *            the parameters are ignored.
     */
    public static void main(String... args) {

        // Input array with arbitrarily nested arrays of integers
        Object[] inputs = new Object[] { new Object[] { 1, 2, new Object[] { 3 } }, 4 };

        // Flatten the input array into a flat array of integers and return a
        // list of integers.
        flattenArray(inputs);
    }

    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat
     * array of integers.
     * 
     * @param inputs
     *            an array with arbitrarily nested arrays of integers.
     * @return an array of integers.
     */
    public static Integer[] flattenArray(Object[] inputs) {

        LOGGER.info("Flattening input array {}.", Arrays.deepToString(inputs));

        List<Integer> flattenedList = doFlattenArray(inputs);

        // Flatten the input array into a flat array of integers and return a
        // list of integers.
        Integer[] results = flattenedList.toArray(new Integer[0]);

        LOGGER.info("Flattened output array {}.", Arrays.deepToString(results));

        return results;
    }

    /**
     * Flatten an array of arbitrarily nested arrays of integers into a flat
     * array of integers.
     * 
     * @param inputs
     *            an array with arbitrarily nested arrays of integers.
     * @return an list of integers.
     */
    private static List<Integer> doFlattenArray(Object[] inputs) {

        List<Integer> flattenedList = new ArrayList<Integer>();
        for (Object obj : inputs) {
            if (obj instanceof Integer) {
                flattenedList.add((Integer) obj);
            } else {
                flattenedList.addAll(doFlattenArray((Object[]) obj));
            }
        }

        return flattenedList;
    }
}
