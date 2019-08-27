package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Week2Test {

    @Test
    void maximum() {
        int[] values = {5, 7, 9, 2, 1, 11, 13, 8};

        //Sjekk at forventede verdier fungerer
        assertEquals(13, Week2.maximum(values, 0, values.length));
        assertEquals(11, Week2.maximum(values, 3, 6));

        //Test exceptions som dette.
        //NOTE: her bruker vi en såkalt lambda-funksjon som andre argument
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> {Week2.maximum(values, -5, 5);});
    }
}