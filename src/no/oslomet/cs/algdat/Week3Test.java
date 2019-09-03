package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Week3Test {

    @Test
    void findMax() {
        int[] values = {1, 7, 2, 4, 6};

        assertEquals(1, Week3.findMax(values, 0, 4));

        int max_1 = Week3.findMax(values, 0, 4);
        assertEquals(7, values[max_1]);

        int max_2 = Week3.findMax(values, 2, 4);
        assertEquals(4, max_2);
        assertEquals(6, values[max_2]);
    }

    @Test
    void selectionSort() {
        int[] values = {1, 7, 2, 4, 6};

        Week3.selectionSort(values);

        System.out.println(Arrays.toString(values));
    }

    @Test
    void binarySearch() {
        int[] values = {1, 2, 4, 6, 7, 9, 17};

        int index_7 = Week3.binarySearch(values, 7);
        assertEquals(4, index_7);

        int index_8 = Week3.binarySearch(values, 8);
        assertEquals(5, index_8);


    }
}