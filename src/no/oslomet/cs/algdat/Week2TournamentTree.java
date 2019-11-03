package no.oslomet.cs.algdat;

import java.security.InvalidParameterException;

public class Week2TournamentTree {
    /**
     * Finner maksimum i det halvåpne intervallet [begin, end)
     * @param values
     * @param begin
     * @param end
     * @return
     */
    public static int maximum(int[] values, int begin, int end) {
        //Parametersjekking
        if (begin < 0 || end >values.length) {
            throw new ArrayIndexOutOfBoundsException("Feil parameterverdier");
        }
        else if (begin >= end) {
            throw new InvalidParameterException("Feil parameterverdier");
        }

        int max_value = values[begin];
        //NOTE: this for loop loops over all elements in
        //[begin+1, end-1]
        for (int i=begin+1; i<end; ++i) {
            if (max_value < values[i]) {
                max_value = values[i];
            }
        }
        return max_value;
    }

    public class BinaryTreeNode {
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;
        int value;

        BinaryTreeNode(int value) {
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }
    }


    int maxValueBinaryTree(int[] values) {
        //Vi starter med å anta at values.length == 8. vil kræsje ellser...

        BinaryTreeNode[] level3 = new BinaryTreeNode[values.length];

        for (int i=0; i<values.length; ++i) {
            level3[i] = new BinaryTreeNode(values[i]);
        }

        /**
         * Level 2 her
         */
        BinaryTreeNode[] level2 = new BinaryTreeNode[values.length / 2];
        for (int i=0; i<level2.length; ++i) {
            BinaryTreeNode left_child = level3[2*i];
            BinaryTreeNode right_child = level3[2*i+1];
            int value = Math.max(left_child.value, right_child.value);

            level2[i] = new BinaryTreeNode(value);
            level2[i].left_child = left_child;
            level2[i].right_child = right_child;
        }


        /**
         * Level 1 her
         */
        BinaryTreeNode[] level1 = new BinaryTreeNode[level2.length / 2];
        for (int i=0; i<level1.length; ++i) {
            BinaryTreeNode left_child = level2[2*i];
            BinaryTreeNode right_child = level2[2*i+1];
            int value = Math.max(left_child.value, right_child.value);

            level1[i] = new BinaryTreeNode(value);
            level1[i].left_child = left_child;
            level1[i].right_child = right_child;
        }

        /**
         * Level 0 her
         */
        BinaryTreeNode left_child = level1[0];
        BinaryTreeNode right_child = level1[1];
        int value = Math.max(left_child.value, right_child.value);
        BinaryTreeNode level0 = new BinaryTreeNode(value);

        return level0.value;


    }

}
