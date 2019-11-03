package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Week4QuickSortTest {

    @Test
    void factorial() {
        assertEquals(5*4*3*2*1, Week4QuickSort.factorial(5));
    }

    @Test
    void binarySearch() {
        int[] values = {1, 2, 4, 6, 7, 9, 17};

        //Search for 7
        int index_7 = Week4QuickSort.binarySearch(values, 7);
        assertEquals(4, index_7);

        //Search for 8 (not found, should be in place 5)
        int index_8 = Week4QuickSort.binarySearch(values, 8);
        assertEquals(5, index_8);
    }

    @Test
    void doubleTest() {
        Week4QuickSort.doubleTest();
    }

    @Test
    void isGreaterThan() {
        assertEquals(true, Week4QuickSort.isGreaterThan('D', 'A'));
        assertEquals(true, Week4QuickSort.isGreaterThan(7, 2));
        assertEquals(false, Week4QuickSort.isGreaterThan(4.3, 7.6));
        assertEquals(true, Week4QuickSort.isGreaterThan("abc", "bac"));
    }
}