
/**
 *
 * @author Dimitar
 */
public class RecursiveBinarySearch {

    public static int binarySearch(int[] array, int x) {
        return binarySearch(array, 0, array.length, x);
    }

    /**
     * Recursive implementation.
     *
     * @param array
     * @param start
     * @param end
     * @param x
     * @return
     */
    private static int binarySearch(int[] array, int start, int end, int x) {
        if (start <= end) {
            int middle = start + (end - start) / 2;

            if (array[middle] == x) {
                return middle;
            } else if (array[middle] < x) {
                return binarySearch(array, middle + 1, end, x);
            } else {
                return binarySearch(array, start, middle - 1, x);
            }
        }
        return -1;
    }
}
