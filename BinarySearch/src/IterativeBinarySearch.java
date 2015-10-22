/**
 *
 * @author Dimitar
 */
public class IterativeBinarySearch {

    /**
     * Returns the position of the searched element from the array. If it
     * doesn't exist -> return -1.
     *
     * @param x
     * @param array
     * @return
     */
    public static int binarySearch(int x, int[] array) {
        int start = 0;
        int end = array.length;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (array[middle] == x) {
                return middle;
            } else if (array[middle] < x) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }
}
