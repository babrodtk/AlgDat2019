package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Week3BinSearchAndSelectionSort {

    /**
     * Function which finds the index of the maximum value
     * in the interval [left, right]
     * @param values Values to search through
     * @param left
     * @param right
     * @return Index to maximum value
     */
    public static int findMax(int[] values, int left, int right) {

        // FIXME: We need to check arguments here!

        // Initialize max value and index to first element
        int max_value = values[left];
        int max_index = left;

        // Loop through all remaining elements and find max
        for (int i=left+1; i<=right; ++i) {
            if (values[i] > max_value) {
                max_value = values[i];
                max_index = i;
            }
        }

        //Return max index
        return max_index;
    }

    /**
     * Swaps the two elements values[from] and values[to]
     * @param values
     * @param from
     * @param to
     */
    public static void swap(int[] values, int from, int to) {
        int tmp = values[from];
        values[from] = values[to];
        values[to] = tmp;
    }

    /**
     * Sorts an array using selection sort,
     * @see https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#1.3.4
     * @param values Values to sort (in place)
     */
    public static void selectionSort(int[] values) {

        //Sort the array one element at a time
        for (int i=0; i<values.length-1; ++i) {
            System.out.println("Iteration " + i);
            System.out.println("Before sort: " + Arrays.toString(values));

            //Determine the interval to find the maximum value
            int left = i;
            int right = values.length-1;

            System.out.println("Searching in [" + left + ", " + right + "]");

            //Find index of maximum value
            int max_index = findMax(values, left, right);

            System.out.println("Maximum is " + values[max_index] + " at position " + max_index);

            //Swap elements - move maximum to left
            swap(values, left, max_index);

            //Print array
            System.out.println("After sort: " + Arrays.toString(values));
        }
    }


    /**
     * Uses binary search to find a value in an array
     * @see https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#1.3.6
     * @param values Values to search through
     * @param value Value to search for
     * @return Index of value if found, or where the value would be
     */
    public static int binarySearch(int[] values, int value) {
        int left = 0;
        int right = values.length-1;

        /**
         * Search while we have an interval to search through
         */
        while (left <= right) {
            System.out.println("Searching in [" + left + ", " + right + "]");

            //NOTE: Integer division!
            int mid = (left + right) / 2;

            if (value < values[mid]) {
                //Search left of mid
                right = mid - 1;
            }
            else if (value > values[mid]) {
                //Search right of mid
                left = mid + 1;
            }
            if (value == values[mid]) {
                //Found value
                return mid;
            }
        }

        //Value not found!
        //Returning where it should be placed
        return left;
    }

}
