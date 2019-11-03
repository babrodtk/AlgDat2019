package no.oslomet.cs.algdat;

public class Week9BinaryTree {

    /**
     * BTNode is a binary tree node
     */
    public static class BTNode {

        BTNode(char value) {
            this.value = value;
            this.parent = null;
            this.right = null;
            this.left = null;
        }

        BTNode parent; //< Note: We don't use this in this
        BTNode right; //< Left child
        BTNode left; //< Right child
        char value; //< Value of node
    }


    public static void printBTreePostOrder(BTNode node) {
        if (node == null) {
            return;
        }
        else {
            printBTreePostOrder(node.left);
            printBTreePostOrder(node.right);
            System.out.print(node.value + ", ");
        }
    }

    public static void printBTreePreOrder(BTNode node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.value + ", ");
            printBTreePreOrder(node.left);
            printBTreePreOrder(node.right);
        }
    }

    public static void printBTreeInOrder(BTNode node, int id) {
        if (node == null) {
            return;
        } else {
            printBTreeInOrder(node.left, id*2);
            System.out.print(node.value + " (Node nummer=" + id + "), ");
            printBTreeInOrder(node.right, id*2 + 1);
        }
    }

    public static void printBTreePreOrderStack(BTNode node) {
        java.util.Stack<BTNode> stack = new java.util.Stack<BTNode>();

        //Legg til rot-noden
        stack.push(node);

        while (!stack.empty()) {
            //Push => legger ting på stacken
            //pop => tar ut øverste element fra stacken
            //peek => viser øverste element på stacken, men tar ikke ut

            BTNode current = stack.pop();
            System.out.print(current.value + ", ");

            //NB: Add right child first!
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

        }
    }

    public static void printBTreeLevelOrder(BTNode node) {
        //I printBTPreOrderStack brukte vi java.util.Stack, en LIFO-kø (last in, first out)
        //Dette ga oss dybde først.

        //Her skal vi bruke bredde først!
        //push, pop, og en while-løkke

        java.util.Deque<BTNode> fifo_queue = new java.util.ArrayDeque<BTNode>();
        fifo_queue.addFirst(node);

        while(fifo_queue.size() > 0) {
            BTNode current = fifo_queue.removeLast();

            System.out.print(current.value + ", ");

            if (current.left != null) {
                fifo_queue.addFirst(current.left);
            }
            if (current.right != null) {
                fifo_queue.addFirst(current.right);
            }
        }
    }


    public static void main(String[] args) {

        //Create level 0
        BTNode root = new BTNode('A');

        //Create level 1
        root.left = new BTNode('B');
        root.right = new BTNode('C');

        //Create level 2
        root.left.left = new BTNode('D');

        root.right.left = new BTNode('E');
        root.right.right = new BTNode('F');

        //Create level 3
        root.right.left.left = new BTNode('G');


        System.out.println("Post order: ");
        printBTreePostOrder(root);
        System.out.println("");

        System.out.println("Pre order: ");
        printBTreePreOrder(root);

        System.out.println("");
        System.out.println("In order: ");
        printBTreeInOrder(root, 1);

        System.out.println("");
        System.out.println("Iterative pre order: ");
        printBTreePreOrderStack(root);

        System.out.println("");
        System.out.println("Level order: ");
        printBTreeLevelOrder(root);
    }
}
