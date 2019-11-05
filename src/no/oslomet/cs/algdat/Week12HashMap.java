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

        /**
         * Lager et nytt hashmap med størrelse capacity på selve tabellen.
         * @param capacity
         */
        HashMap(int capacity) {
            hash_map = new LinkedList[capacity];
            for (int i=0; i<capacity; ++i) {
                hash_map[i] = new LinkedList<Value>();
            }
        }

        /**
         * Lager en hash (heltall) fra en streng med bokstaver
         * @param key
         * @return
         */
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

        /**
         * Returnerer en verdi mellom [0, capacity)
         * fra hash'en gitt som input
         * @param key_hash
         * @return
         */
        int getIndex(int key_hash) {
            int capacity = hash_map.length;
            int index = key_hash % capacity;
            return index;
        }

        void add(String key, int value) {
            //Lag hash av nøkkel
            int key_hash = hash(key);

            //Kjør modulus med capacity for å finne riktig lenket liste
            int index = getIndex(key_hash);

            //Lag verdi-noden som har nøkkel og verdi
            Value v = new Value();
            v.name = key;
            v.sallary = value;

            //Legg inn v på plassen index sin lenkede liste
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


            //Lineært søk gjennom den lenkede listen
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
