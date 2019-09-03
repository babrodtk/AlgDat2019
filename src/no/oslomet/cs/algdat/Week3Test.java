package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Remember: Use alt+enter on the Week3 class to create this test class
 */
class Week3Test {

    @Test
    void findMax() {
        int[] values = {1, 7, 2, 4, 6};

        //Search in [0, 4] - check index
        int max_1 = Week3.findMax(values, 0, 4);
        assertEquals(1, max_1);
        assertEquals(7, values[max_1]);

        //Search in [2, 4]
        int max_2 = Week3.findMax(values, 2, 4);
        assertEquals(4, max_2);
        assertEquals(6, values[max_2]);

        //FIXME: Check more arrays!
    }

    @Test
    void selectionSort() {
        int[] values = {1, 7, 2, 4, 6};
        int[] sorted = {7, 6, 4, 2, 1};

        //NOTE: sorts in place (changes values)
        //NOTE: Uses assertArrayEquals to check arrays for equality
        Week3.selectionSort(values);
        assertArrayEquals(values, sorted);
    }

    @Test
    void binarySearch() {
        int[] values = {1, 2, 4, 6, 7, 9, 17};

        //Search for 7
        int index_7 = Week3.binarySearch(values, 7);
        assertEquals(4, index_7);

        //Search for 8 (not found, should be in place 5)
        int index_8 = Week3.binarySearch(values, 8);
        assertEquals(5, index_8);
    }
}