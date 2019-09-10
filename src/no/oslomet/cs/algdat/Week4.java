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

    /**
     * Dummy testing function to see how we can compare
     * strings
     */
    public static void testIfItWorks() {
        String a = "abc";
        String b = "bac";

        /**
         * Wrong, doens't work
         *
        if (a > b) {
            System.out.println("It works");
        }
         */

        /**
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
     * @param a
     * @param b
     * @return (a > b)
     */
    public static <T extends Comparable<? super T>>
    boolean isGreaterThan(T a, T b) {
        System.out.println("a="+ a + ", b=" + b);

        //a.compareTo() fungerer for String
        //if (a > b) {
        if (a.compareTo(b) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void myTest() {
        Double b = 3.2;
        if (b.compareTo(3.4) > 0) {
            System.out.println("FOO");
        }
    }



    public static void swap(int[] values, int from, int to) {
        int tmp = values[from];
        values[from] = values[to];
        values[to] = tmp;
    }

    public static int partition(int[] values, int begin, int end, int pivot_index) {
        swap(values, pivot_index, end-1);

        int l = begin;
        int r = end-2;

        while (l < r) {
            //Move left pointer until first larger
            while (l <= r && values[l] < values[end-1]) {
                ++l;
            }
            while (l <= r && values[r] > values[end-1]) {
                --r;
            }
            if (l < r) {
                swap(values, l, r);
                ++l;
                --r;
            }
        }

        swap(values, l, end-1);

        return l;
    }


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
