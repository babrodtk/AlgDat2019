package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Week12HashMapTest {

    String[] names = {
            "PER",
            "SIRI",
            "ALI",
            "ESPEN",
            "ESPEN PEDER SIRI ALI TORSTEIN GREGER RAJA OLE"
    };

    int[] sallaries = {
            400,
            200,
            600,
            5,
            90
    };

    @Test
    void testHashFunction() {
        //Test hash-funksjonen
        for (String name : names) {
            int hash = Week12HashMap.HashMap.hash(name);
            System.out.println(name + " - " + hash);
            assertTrue(hash >= 0);
        }
    }

    @Test
    void testIndexFunction() {
        int capacity = 13;
        Week12HashMap.HashMap hash_map = new Week12HashMap.HashMap(capacity);

        //Test getIndex-funksjonen
        for (String name : names) {
            int hash = Week12HashMap.HashMap.hash(name);
            int index = hash_map.getIndex(hash);
            System.out.println(name + " - " + hash + " - " + index);
            assertTrue(index >= 0 && index < capacity);
        }
    }


    @Test
    void testAddGet() {
        Week12HashMap.HashMap hash_map = new Week12HashMap.HashMap(13);

        //Legg inn verdier i hash-map
        for (int i=0; i<names.length; ++i) {
            hash_map.add(names[i], sallaries[i]);
        }

        //Hent ut verdier fra hash-map
        for (int i=0; i<names.length; ++i) {
            int hash_map_sallary = hash_map.get(names[i]);
            int true_sallary = sallaries[i];
            assertEquals(hash_map_sallary, true_sallary);
        }

        //Sjekk at vi ikke har "NORA" i hash-map'et
        assertThrows(RuntimeException.class, () -> hash_map.get("NORA"));
    }
}