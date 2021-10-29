package synthesizer;

public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;
    private static final double DECAY = .996;

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        double division = SR / frequency;
        int capacity = (int) Math.round(division);
        buffer = new ArrayRingBuffer<>(capacity);
        this.pluck();
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */

    /**
     * Dequeue everything in the buffer, and replace it with random numbers
     * between -0.5 and 0.5. You can get such a number by using:
     * double r = Math.random() - 0.5;
     * make suer your random number is different from each other.
     */
    public void pluck() {
        int fillCount = buffer.fillCount();
        for (int i = 0; i < fillCount; i++) {
            buffer.dequeue();
        }
         for (int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        Double front = sample();
        Double newSample = (front + buffer.peek()) / 2 * DECAY;
        buffer.enqueue(front);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.dequeue();
    }
}
