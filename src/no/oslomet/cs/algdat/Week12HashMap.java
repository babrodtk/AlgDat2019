package no.oslomet.cs.algdat;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.LinkedList;
import java.util.ListIterator;

public class Week12HashMap {
    public static class Value {
        String name; //espen, pål, siri, ali, ...
        int sallary;
    }

    public static class HashMap {
        LinkedList<Value>[] hash_map;

        HashMap(int capacity) {
            hash_map = new LinkedList[capacity];
            for (int i=0; i<capacity; ++i) {
                hash_map[i] = new LinkedList<Value>();
            }
        }

        public static int hash(String key) {
            int result = 1;

            for (int i=0; i<key.length(); ++i) {
                char c = key.charAt(i);
                int c_int = (int) c; //Gjør om ved å bruke ascii-tabellen ('A' = 65, ...

                result = (result*31) + c_int;
            }

            if (result < 0) {
                result = result * -1;
            }

            return result;
        }

        int getIndex(int key_hash) {
            int capacity = hash_map.length;
            int index = key_hash % capacity;
            return index;
        }

        void add(String key, int value) {
            //Lag hash av nøkkel
            int key_hash = hash(key);

            //Kjør modulus med capacity
            int index = getIndex(key_hash);

            //Legg inn i lenket liste på riktig indeks
            Value v = new Value();
            v.name = key;
            v.sallary = value;

            hash_map[index].add(v);
        }

        int get(String key) {
            //Lag hash av nøkkel
            int key_hash = hash(key);

            //Regn ut indeks fra nøkkelen
            int index = getIndex(key_hash);

            //Hent ut verdien
            //Søk her hvis lenket liste har fler enn en verdi
            LinkedList<Value> lenket_liste = hash_map[index];

            ListIterator iter = lenket_liste.listIterator();
            while (iter.hasNext()) {
                Value v = (Value) iter.next();
                String name = v.name;
                if (name == key) {
                    return v.sallary;
                }
            }
            throw new RuntimeException("Ikke funnet");
        }
    }

}
