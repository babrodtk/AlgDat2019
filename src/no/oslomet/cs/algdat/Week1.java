package no.oslomet.cs.algdat;

import java.util.Random;

public class Week1 {

    public static void main(String[] args) {
        System.out.println("Hello world");

        int num_values = 10;
        int[] values = new int[num_values];

        long tic = System.currentTimeMillis();
        Random rand = new Random();
        for (int i=0; i<num_values; ++i) {
            values[i] = rand.nextInt(100);
        }
        long toc = System.currentTimeMillis();

        System.out.println("Elapsed: " + (toc-tic) + " ms");


    }

    public static int findMax(int[] values) {
        int max_value = 0;

        for (int i=0; i<values.length; ++i) {
            if (max_value < values[i]) {
                max_value = values[i];
            }
        }
        return max_value;
    }

    public static String toString(int[] values) {
        String retval = "";

        retval = "[" + values[0];
        for (int i=1; i<values.length; ++i) {
            retval = retval + ", " + values[i];
        }
        retval = retval + "]";

        return retval;

    }
}
