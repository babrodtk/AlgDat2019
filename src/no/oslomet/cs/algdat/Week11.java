package no.oslomet.cs.algdat;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Week11 {
    static String message = "Duncan. What bloody man is that? He can report,\n" +
            "As seemeth by his plight, of the revolt\n" +
            "The newest state.20\n" +
            "Malcolm. This is the sergeant\n" +
            "Who like a good and hardy soldier fought\n" +
            "'Gainst my captivity. Hail, brave friend!\n" +
            "Say to the king the knowledge of the broil\n" +
            "As thou didst leave it.25\n" +
            "Sergeant. Doubtful it stood;\n" +
            "As two spent swimmers, that do cling together\n" +
            "And choke their art. The merciless Macdonwald—\n" +
            "Worthy to be a rebel, for to that\n" +
            "The multiplying villanies of nature30\n" +
            "Do swarm upon him—from the western isles\n" +
            "Of kerns and gallowglasses is supplied;\n" +
            "And fortune, on his damned quarrel smiling,\n" +
            "Show'd like a rebel's whore: but all's too weak:\n" +
            "For brave Macbeth—well he deserves that name—35\n" +
            "Disdaining fortune, with his brandish'd steel,\n" +
            "Which smoked with bloody execution,\n" +
            "Like valour's minion carved out his passage\n" +
            "Till he faced the slave;\n" +
            "Which ne'er shook hands, nor bade farewell to him,40\n" +
            "Till he unseam'd him from the nave to the chaps,\n" +
            "And fix'd his head upon our battlements.\n" +
            "Duncan. O valiant cousin! worthy gentleman!\n" +
            "Sergeant. As whence the sun 'gins his reflection\n" +
            "Shipwrecking storms and direful thunders break,45\n" +
            "So from that spring whence comfort seem'd to come\n" +
            "Discomfort swells. Mark, king of Scotland, mark:\n" +
            "No sooner justice had with valour arm'd\n" +
            "Compell'd these skipping kerns to trust their heels,\n" +
            "But the Norweyan lord surveying vantage,50\n" +
            "With furbish'd arms and new supplies of men\n" +
            "Began a fresh assault.\n" +
            "Duncan. Dismay'd not this\n" +
            "Our captains, Macbeth and Banquo?\n" +
            "Sergeant. Yes;55\n" +
            "As sparrows eagles, or the hare the lion.\n" +
            "If I say sooth, I must report they were\n" +
            "As cannons overcharged with double cracks, so they\n" +
            "Doubly redoubled strokes upon the foe:\n" +
            "Except they meant to bathe in reeking wounds,60\n" +
            "Or memorise another Golgotha,\n" +
            "I cannot tell.\n" +
            "But I am faint, my gashes cry for help.\n" +
            "Duncan. So well thy words become thee as thy wounds;\n" +
            "They smack of honour both. Go get him surgeons.65\n" +
            "[Exit Sergeant, attended]\n" +
            "Who comes here?\n" +
            "[Enter ROSS]\n" +
            "\n" +
            "Malcolm. The worthy thane of Ross.\n" +
            "Lennox. What a haste looks through his eyes! So should he look70\n" +
            "That seems to speak things strange.\n" +
            "Ross. God save the king!\n" +
            "Duncan. Whence camest thou, worthy thane?\n" +
            "Ross. From Fife, great king;\n" +
            "Where the Norweyan banners flout the sky75\n" +
            "And fan our people cold. Norway himself,\n" +
            "With terrible numbers,\n" +
            "Assisted by that most disloyal traitor\n" +
            "The thane of Cawdor, began a dismal conflict;\n" +
            "Till that Bellona's bridegroom, lapp'd in proof,80\n" +
            "Confronted him with self-comparisons,\n" +
            "Point against point rebellious, arm 'gainst arm.\n" +
            "Curbing his lavish spirit: and, to conclude,\n" +
            "The victory fell on us.\n" +
            "Duncan. Great happiness!85\n" +
            "Ross. That now\n" +
            "Sweno, the Norways' king, craves composition:\n" +
            "Nor would we deign him burial of his men\n" +
            "Till he disbursed at Saint Colme's inch\n" +
            "Ten thousand dollars to our general use.90\n" +
            "Duncan. No more that thane of Cawdor shall deceive\n" +
            "Our bosom interest: go pronounce his present death,\n" +
            "And with his former title greet Macbeth.\n" +
            "Ross. I'll see it done.\n" +
            "Duncan. What he hath lost noble Macbeth hath won.";

    public static class HuffNode {
        HuffNode(char value, int frequency) {
            this.value = value;
            this.frequency = frequency;
            this.huffcode = "";
        }

        HuffNode(HuffNode left, HuffNode right) {
            this.left = left;
            this.right = right;
            this.frequency = left.frequency + right.frequency;
            this.huffcode = "";
        }

        HuffNode left;
        HuffNode right;

        char value;
        int frequency;
        String huffcode;
    }


    public static void main(String[] args) {
        //Testmelding for utvikling
        //String message = "AAAAAKBBCRR";

        //Tabell slik at frequency[(int) 'A'] gir frekvensen til bokstaven 'A' (se ASCII for mer info)
        int[] frequency = new int[256];

        //Loop over meldingen og tell frekvens for alle bokstaver
        for (int i=0; i<message.length(); ++i) {
            char character = message.charAt(i);
            int index = (int) character;

            // Enkelte bokstaver faller utenfor ASCII-tabellen (UTF-8),
            // og de ignorerer vi her i vårt eksempel
            if (index > 256) {
                //We don't care about utf-8
                continue;
            }

            //Øk frekvensen til character med en
            frequency[index] += 1;
        }

        /**
         * Comparator som sammenlikner to HuffNode ved å sammenlikne frekvensene
         */
        Comparator<HuffNode> huffNodeComparator = (s1, s2) -> {
            return s1.frequency - s2.frequency;
        };

        //Prioritetskø som bruker den nye comparatoren
        PriorityQueue<HuffNode> queue = new PriorityQueue<>(huffNodeComparator);

        //Legg inn alle bokstaver med ikke-null frekvens i prioritetskøen
        System.out.println("Add to priority queue");
        for (int i=0; i<256; ++i) {
            //Finn tallverdien til bokstaven, f.eks. er 'A' == 65, 'B' == 66, osv (se ASCII)
            char character = (char) i;

            //Bruk kun bokstaver som forekommer i teksten
            if (frequency[i] > 0) {
                HuffNode leaf_node = new HuffNode(character, frequency[i]);
                queue.add(leaf_node);
                System.out.println("La inn " + character + ": " + frequency[i]);
            }
        }

        System.out.println("Priority queue");
        while (queue.size() >= 2) {
            HuffNode left_node = queue.remove();
            HuffNode rigth_node = queue.remove();

            HuffNode parent = new HuffNode(left_node, rigth_node);

            queue.add(parent);
            //System.out.println(node.value + ": " + node.frequency);
        }

        HuffNode root = queue.remove();

        HashMap<Character, String> letter_to_huffcode = new HashMap<>();

        //Utskrift - nivå orden
        System.out.println("Utskrift i nivå orden:");
        ArrayDeque<HuffNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            HuffNode parent = deque.removeFirst();

            if (parent.left == null && parent.right == null) {
                System.out.println(parent.value + " (" + parent.frequency + "): " + parent.huffcode);
                letter_to_huffcode.put(parent.value, parent.huffcode);
            }
            else {
                System.out.println("* - " + parent.frequency);
            }

            if (parent.left != null) {
                deque.addLast(parent.left);
                parent.left.huffcode = parent.huffcode + "0";
            }
            if (parent.right != null) {
                deque.addLast(parent.right);
                parent.right.huffcode = parent.huffcode + "1";
            }
        }


        System.out.println("Coding message");
        int bit_coded = 0;
        for (int i=0; i<message.length(); ++i) {
            Character c = message.charAt(i);
            if ((int) c >= 256) {
                continue;
            }
            String huff_code = letter_to_huffcode.get(c);
            bit_coded += huff_code.length();
            System.out.print(huff_code);
        }
        System.out.println();
        System.out.println("Coded message used " + bit_coded + " bits");
        System.out.println("Original message used " + message.length()*8 + " bits");
    }
}
