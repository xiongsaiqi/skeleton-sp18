package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    static public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 11; i++) {
            arb.enqueue(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        someTest();
    }
} 
