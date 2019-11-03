package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Week5MergeSortTest {

    @Test
    void merge() {
        int[] values = {0, 4, 5, 7, 9, 13,
                        2, 3, 6, 8, 11, 12};
        int[] tmp = new int[6];

        Week5MergeSort.merge(values, tmp, 0, 6, values.length);
        System.out.println(Arrays.toString(values));

        int[] sorted = {0, 2, 3, 4, 5, 6,
                        7, 8, 9, 11, 12, 13};
        assertArrayEquals(sorted, values);
    }

    @Test
    void mergeSort() {
        int values[] = {0, 9, 7, 6, 2, 1, 5, 3, 4};
        int reference[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};

        Week5MergeSort.mergeSort(values);

        assertArrayEquals(reference, values);
    }
}