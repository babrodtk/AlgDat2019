package no.oslomet.cs.algdat;

public class Week6LinkedList {

    /**
     * Simple class that holds a number. Used in a linked list
     */
    public static class Node {

        /**
         * Default-konstruktør hvis vi ikke kjenner verdi eller
         * neste-peker, men allikevel skal legge den til vår
         * lenkede liste.
         */
        public Node() {
            //Hvis this.value blir skrevet ut eller brukt i koden
            //så er det lettere å kjenne igjen et tall som
            //MAX_VALUE enn f.eks. 0 eller andre tall.
            this.value = Integer.MAX_VALUE;

            //Sett neste-peker til null for å lage nullpointerexception
            //hvis vi bruker denne.
            this.next = null;
            this.prev = null;
        }

        // Konstruktør hvor vi vet verdien vi skal sette inn
        // i den lenkede listen.
        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        /**
         * Konstruktør hvor vi vet både verdi og neste-peker
         *
         * @param value
         * @param next
         */
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = null;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        //Pointer to next node in linked list
        Node next;

        //Pointer to previous node in linked list
        Node prev;

        //Value of this node
        int value;
    }

    public static void printLinkedList(Node front) {
        Node current = front;
        System.out.print("[" + current.value);
        current = current.next;
        while (current != null) {
            System.out.print(", " + current.value);
            current = current.next;
        }
        System.out.println("]");
    }

    public static void printLinkedListReverse(Node back) {
        Node current = back;
        System.out.print("[" + current.value);
        current = current.prev;
        while(current != null) {
            System.out.print(", " + current.value);
            current = current.prev;
        }
        System.out.println("]");
    }

    public static void main(String args[]) {
        //Create empty linked list
        //front == back
        Node front = new Node();
        Node back = front;

        System.out.println("Original liste:");
        printLinkedList(front);

        // VI skal legge inn følgende tall
        // [0, 1, 3, 4]
        { // begin scope
            int values[] = {0, 1, 3, 4};

            // Create pointer to p node
            Node p = front;

            // Set value of first node in array
            p.value = values[0];

            // Legger inn ny node i slutten av listen
            for (int i=1; i<values.length; ++i) {

                //Create new node
                Node q = new Node(values[i]);

                //Set next pointer of p and
                //prev pointer of q
                q.prev = p;
                p.next = q;

                //advance p so that it now points to q
                p = q;

                //Set back pointer to point to q, the last node
                back = q;
            }
        } // end scope

        System.out.println("Liste etter innlegging av tall:");
        printLinkedList(front);

        /**
         * Legge til node 2 midt i listen
         */
        { // Begin scope
            Node p = front;
            for (int i=0; i<1; ++i) {
                p = p.next;
            }
            Node r = p.next;
            System.out.println("P er nå på " + p.value);

            //Create the new node q
            Node q = new Node(2);

            //Set pointers between q and r
            q.next = r;
            r.prev = q;

            //Set pointers between p and q
            q.prev = p;
            p.next = q;

            System.out.println("Q er nå på " + q.value);
            System.out.println("R er nå på " + r.value);
        }

        System.out.println("Liste etter innlegging av 2");
        printLinkedList(front);

        /**
         * Legge til node -1 i starten av listen
         */
        { // begin scope
            Node p = new Node(-1, front);
            front.prev = p;
            front = p;
        } //end scope

        System.out.println("Liste etter innlegging av -1");
        printLinkedList(front);



        /**
         * Fjerne node 3
         */
        { // Begin scope
            Node p = front;

            for (int i=0; i<3; ++i) {
                p = p.next;
            }

            Node q = p.next;
            Node r = q.next;

            System.out.println("P er nå på " + p.value);
            System.out.println("Q er nå på " + q.value);
            System.out.println("R er nå på " + r.value);

            //Fjern node q
            p.next = r;
            r.prev = p;
        }
        System.out.println("Liste etter fjerning av 3");
        printLinkedList(front);


        System.out.println("Revers liste");
        printLinkedListReverse(back);


    }
}
