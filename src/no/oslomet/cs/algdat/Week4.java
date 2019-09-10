package no.oslomet.cs.algdat;

public class Week4 {

    /**
     * Regner ut fakultet:
     * n * (n-1) * (n-2) * ... * 1
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return factorial(n - 1) * n;
        }
    }


    /**
     * Binary search - recursive version
     */
    public static int binarySearch(int[] values, int value, int left, int right) {
        if (right - left < 0) {
            return left;
        }

        int middle = (left + right) / 2;

        if (value > values[middle]) {
            return binarySearch(values, value, middle+1, right);
        }
        else if (value < values[middle]) {
            return binarySearch(values, value, left, middle-1);
        }
        else {
            return middle;
        }
    }


    /**
     * Starts the recursion
     * @param values
     * @param value
     * @return
     */
    public static int binarySearch(int[] values, int value) {
        return binarySearch(values, value, 0, values.length-1);
    }

}
