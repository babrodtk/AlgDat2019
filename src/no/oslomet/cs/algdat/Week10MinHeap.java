package no.oslomet.cs.algdat;

import java.util.Arrays;

public class Week10MinHeap {

    public static class MinHeap {
        char[] data;
        int size;
        int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.data = new char[capacity];
            this.size = 0;
        }

        public static double log2(double a) {
            return Math.log10(a) / Math.log10(2);
        }

        public void print() {
            System.out.println("Size: " + this.size);
            System.out.println("Capacity: " + this.capacity);
            System.out.println("Array: " + Arrays.toString(data));

            System.out.println("Min heap:");
            for (int i=0; i<this.capacity; ++i) {
                double log2_i = log2(i + 1);
                if (i > 0 && log2_i % 1 == 0.0) {
                    System.out.println(" ");
                }
                if (i < this.size) {
                    System.out.print("'" + this.data[i] + "', ");
                }
                else {
                    System.out.print("(" + this.data[i] + "),");
                }
            }
            System.out.println(" ");
        }

        public void swap(int node_a, int node_b) {
            char tmp = this.data[node_a-1];
            this.data[node_a-1] = this.data[node_b-1];
            this.data[node_b-1] = tmp;
        }

        void push(char a) {

            //Sett inn på siste plass (komplett tre)
            int array_index = this.size;
            this.data[array_index] = a;
            this.size = this.size + 1;

            //FLytt oppover og bytt med forelder hvis større
            int node_index = array_index + 1;
            int parent_index = node_index / 2;
            while (node_index > 1 && this.data[node_index-1] < this.data[parent_index-1]) {
                System.out.println("Bytter " + node_index + " med " + parent_index);

                //swap
                swap(node_index, parent_index);

                //oppdater parent og node
                node_index = parent_index;
                parent_index = parent_index / 2;
            }
        }

        char pop() {
            //Swap first and last
            int first_node = 1;
            int last_node = this.size;
            swap(last_node, first_node);

            //Tricle down
            int node_index = first_node;
            int left_index = node_index * 2;
            int right_index = left_index + 1;

            while (left_index < this.size) {
                //Finn minste barn
                int min_index = left_index;
                if (right_index < this.size && this.data[right_index-1] < this.data[left_index-1]) {
                    min_index = right_index;
                }

                //Bytt med minste barn
                if (this.data[node_index-1] > this.data[min_index-1]) {
                    swap(node_index, min_index);
                }

                //Oppdater pekerne
                node_index = min_index;
                left_index = node_index*2;
                right_index = left_index+1;
            }

            this.size = this.size-1;

            return this.data[last_node-1];
        }

        public int size() {
            return this.size;
        }
    }

    public static void main(String[] args) {
        MinHeap my_heap = new MinHeap(7);

        char[] data = "FQRBCTM".toCharArray();

        //Add all characters to heap and print
        for (int i=0; i<data.length; ++i) {
            System.out.println("La inn '" + data[i] + "'");
            my_heap.push(data[i]);
            my_heap.print();
            System.out.println("");
        }

        while(my_heap.size() > 0) {
            char out = my_heap.pop();
            System.out.println("Tok ut '" + out + "'");
            my_heap.print();
            System.out.println("");
        }
    }

}
