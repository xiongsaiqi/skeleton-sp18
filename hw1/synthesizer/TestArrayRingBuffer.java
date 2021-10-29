package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;


/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */
public class TestArrayRingBuffer {

    @Test
    public static void someTest() {
        ArrayRingBuffer<Integer> dd = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            dd.enqueue(i);
        }
        assertEquals(10, dd.fillCount);
        for (int i = 0; i < 5; i++) {
            dd.dequeue();
        }
        assertEquals(5, dd.fillCount);
    }

    @Test
    public static void guitarStringTest() {
        GuitarString gs = new GuitarString(1000);
        gs.pluck();
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        someTest();
    }
} 
