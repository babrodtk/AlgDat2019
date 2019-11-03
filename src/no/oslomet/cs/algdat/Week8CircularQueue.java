package no.oslomet.cs.algdat;

public class Week8CircularQueue {

    public static class CircularDeque {
        int begin; //< Starten av køen
        int end; //< slutten av køen
        int capacity; //< maksimal størrelse på køen
        int size; //< antall elementer i køen så langt
        char[] values;

        CircularDeque(int capacity) {
            this.begin = 0;
            this.end = 0;
            this.capacity = capacity;
            this.size = 0;
            this.values = new char[capacity];
        }

        void pushBack(char value) {
            //fraTilKontroll....
            if (size == capacity) {
                throw new ArrayIndexOutOfBoundsException("Køen er full!");
            }

            System.out.println("Legger til " + value + " på plass " + end + ", size=" + (size+1));

            values[end] = value;
            end = (end+1) % capacity;
            size = size + 1;
        }

        char popFront() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("Køen er tom!");
            }

            char retval = values[begin];

            System.out.println("Henter ut " + retval + " på plass " + begin + ", size=" + (size-1));

            begin = (begin+1) % capacity;
            size = size - 1;

            return retval;
        }
    }

    public static void main(String args[]) {
        System.out.println("Hello week 8");
    }


}
