package no.oslomet.cs.algdat;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Remember: Use alt+enter on the Week1 class to create this test class
 */
class Week1FindMaxTest {
    @org.junit.jupiter.api.Test
    void findMax() {
        int[] values = {1, 2, 3, 4, 5};

        assertEquals(Week1FindMax.findMax(values), 5);
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
        int[] values = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(values));
        System.out.println(Week1FindMax.toString(values));

        assertEquals(Week1FindMax.toString(values), Arrays.toString(values));
    }


}