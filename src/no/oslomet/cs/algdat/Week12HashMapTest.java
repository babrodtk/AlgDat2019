package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Week12HashMapTest {

    @Test
    void testHashFunction() {
        System.out.println(Week12HashMap.HashMap.hash("PER"));
        System.out.println(Week12HashMap.HashMap.hash("SIRI"));
        System.out.println(Week12HashMap.HashMap.hash("ALI"));
        System.out.println(Week12HashMap.HashMap.hash("ESPEN"));

        //OBS: pass på overflow - her får vi negativ hash!
        System.out.println(Week12HashMap.HashMap.hash(
                "ESPEN PEDER SIRI ALI TORSTEIN GREGER RAJA OLE"
        ));
    }

    @Test
    void testIndexFunction() {
        int hash1  = Week12HashMap.HashMap.hash("PER");
        int hash2  = Week12HashMap.HashMap.hash("SIRI");
        int hash3  = Week12HashMap.HashMap.hash("ALI");
        int hash4  = Week12HashMap.HashMap.hash("ESPEN");
        int hash5 = Week12HashMap.HashMap.hash("ESPEN PEDER SIRI ALI TORSTEIN GREGER RAJA OLE");

        Week12HashMap.HashMap hash_map = new Week12HashMap.HashMap(13);

        System.out.println(hash_map.getIndex(hash1));
        System.out.println(hash_map.getIndex(hash2));
        System.out.println(hash_map.getIndex(hash3));
        System.out.println(hash_map.getIndex(hash4));
        System.out.println(hash_map.getIndex(hash5));

        assertEquals(hash_map.getIndex(hash1), 4);
    }


    @Test
    void testAddGet() {
        Week12HashMap.HashMap hash_map = new Week12HashMap.HashMap(13);

        hash_map.add("PER", 200);
        hash_map.add("ALI", 400);
        hash_map.add("SIRI", 100);

        System.out.println(hash_map.get("PER"));
        System.out.println(hash_map.get("ALI"));
        System.out.println(hash_map.get("SIRI"));
    }
}