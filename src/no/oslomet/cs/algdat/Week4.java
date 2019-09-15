package no.oslomet.cs.algdat;

public class Week4 {

    /**
     * Regner ut fakultet:
     * n * (n-1) * (n-2) * ... * 1
     * Husk: En rekursiv funksjon må kalle seg selv,
     * endre parametere, og ende i ett basistilfelle
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
        // If no interval, nothing to search for
        if (right - left < 0) {
            return left;
        }

        //Find middle index of interval
        int middle = (left + right) / 2;

        // Search right interval
        if (value > values[middle]) {
            return binarySearch(values, value, middle+1, right);
        }
        // Search left interval
        else if (value < values[middle]) {
            return binarySearch(values, value, left, middle-1);
        }
        // Value found!
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

    /**
     * Dummy testing function to see how we can compare
     * strings
     */
    public static void testIfItWorks() {
        String a = "abc";
        String b = "bac";

        /**
         * Wrong, doesn't work - there is no operator > for strings!
         *
        if (a > b) {
            System.out.println("It works");
        }
         */

        /**
         * We can use the function compareTo!
         * a.compareTo(b) == 0 => a og b are equal
         * a.compareTo(b) < 0 => a is less than b
         * a.compareTo(b) > 0 => a is greater than b
         */
        if (a.compareTo(b) == 0) {
            System.out.println(a + " er lik " + b);
        }
        else if (a.compareTo(b) > 0) {
            System.out.println(a + " er større enn " + b);
        }
        else {
            System.out.println(a + " er mindre enn " + b);
        }
    }

    /**
     * This function demonstrates type conversion. Try
     * calling it with
     *  typeConversion(true)
     *  typeConversion('c')
     *  typeConversion(32)
     *  and see what happens
     *  See https://www.w3schools.com/java/java_type_casting.asp
     *  for some more details
     */
    public static void typeConversion(int a) {
        System.out.println("a=" + a);
    }


    /**
     * Function for demonstrating generics in Java
     * <T extends Comparable<? super T>> loosely speaking means something like
     * this function takes any class T as input as long as it implements the
     * Comparable interface. <? super T> is "syntactic sugar" so that we also
     * accept classes that inherit a superclass which implements Comparable
     * @param a
     * @param b
     * @return (a > b)
     */
    public static <T extends Comparable<? super T>>
    boolean isGreaterThan(T a, T b) {
        System.out.println("a="+ a + ", b=" + b);

        if (a.compareTo(b) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Demonstrates that Double is a class in Java that implements
     * the Comparable interface!
     */
    public static void doubleTest() {
        Double b = 3.2;
        if (b.compareTo(3.4) > 0) {
            System.out.println("FOO");
        }
    }


    /**
     * Swaps two values in an array
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
     * Partitions an array.
     * @param values
     * @param begin
     * @param end
     * @param pivot_index
     * @return
     */
    public static int partition(int[] values, int begin, int end, int pivot_index) {
        // First, move our pivot to the end of the array.
        swap(values, pivot_index, end-1);

        int l = begin;
        int r = end-2;

        // Loop over the array and swap until l meets r
        while (l < r) {
            //Find first element from the left larger than pivot
            while (l <= r && values[l] < values[end-1]) {
                ++l;
            }

            //Find first element from the right smaller than pivot
            while (l <= r && values[r] > values[end-1]) {
                --r;
            }

            //If l and r have not met, swap l and r
            if (l < r) {
                swap(values, l, r);
                ++l;
                --r;
            }
        }

        //Swap pivot element back
        swap(values, l, end-1);

        //Return new index of pivot element
        return l;
    }


    /**
     * Implements quicksort using recursion
     * @param values
     * @param left
     * @param right
     */
    public static void quickSort(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }

        // Velg en pivot
        int pivot_index = (left + right) / 2;
        int pivot = values[pivot_index];

        // Partisjonering
        // Sørg for at alle til høyre blir større enn eller lik pivot
        // og at alle til venstre er mindre enn pivot
        int new_pivot_index = partition(values, left, right, pivot_index);

        // Gjenta for høyre subliste og venstre subliste
        quickSort(values, left, new_pivot_index-1);
        quickSort(values, new_pivot_index+1, right);
    }


}
