package no.oslomet.cs.algdat;

public class Week7 {

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

    public static void fjernNode(Node p, Node q, Node r) {
        if (p == null && r == null) {
            //Kun ett element i listen
            //FIXME: front = null;
            //FIXME: back = null;
        }
        if (p == null) {
            //q er første element
            r.prev = null;
            //FIXME: front = r; // OBS! This does not work!!
        }
        else if (r == null) {
            //q er siste element
            p.next = null;
            //FIXME: back = p; // OBS! This does not work!!
        }
        else {
            //Normal fjerning i midten av listen
            p.next = r;
            r.prev = p;
        }
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
            int values[] = {0, 1, 2, 3, 4};

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

        // Vi skal fjerne noden på plass 2.
        { // Start scope
            int indeks = 2; // Denne kommer opprinnelig fra indeksTil eller liknende

            // VI vet at p ligger på indeks-1, q på indeks, og r på indeks+1
            Node p = front;

            for (int i=0; i<indeks-1; ++i) {
                p = p.next;
            }
            Node q = p.next;
            Node r = q.next;

            System.out.println("Vi har nå p=" + p.value);
            System.out.println("Vi har nå q=" + q.value);
            System.out.println("Vi har nå r=" + r.value);

            fjernNode(p, q, r);

            printLinkedList(front);
            printLinkedListReverse(back);
        } // SLutt scope



    } // Slutt main



}
