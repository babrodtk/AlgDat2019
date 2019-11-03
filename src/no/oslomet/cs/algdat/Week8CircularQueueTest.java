package no.oslomet.cs.algdat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Week8CircularQueueTest {

    @Test
    void CircularDequeTest() {
        Week8CircularQueue.CircularDeque c_deque = new Week8CircularQueue.CircularDeque(6);

        c_deque.pushBack('A');
        c_deque.pushBack('B');
        c_deque.pushBack('C');
        c_deque.pushBack('D');
        c_deque.pushBack('E');
        c_deque.pushBack('F');

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> c_deque.pushBack('G'));

        assertEquals('A', c_deque.popFront());
        assertEquals('B', c_deque.popFront());
        assertEquals('C', c_deque.popFront());
        assertEquals('D', c_deque.popFront());
        assertEquals('E', c_deque.popFront());
        assertEquals('F', c_deque.popFront());

    }



    @Test
    void CircularDequeTest2() {
        Week8CircularQueue.CircularDeque c_deque = new Week8CircularQueue.CircularDeque(6);

        char[] my_chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        for (int i=0; i<my_chars.length; ++i) {
            c_deque.pushBack(my_chars[i]);
            assertEquals(my_chars[i], c_deque.popFront());
        }
    }
}