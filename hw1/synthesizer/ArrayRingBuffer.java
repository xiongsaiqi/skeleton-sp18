package synthesizer;
import java.util.Iterator;

/**
 * 这个类就是上面抽线的AbstractBoundedQueue类的具体实现了。
 * @author 熊赛棋
 * @param <T>
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        this.capacity = capacity;
        this.fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last++] = x;
        if (last > capacity - 1) {
            last = 0;
        }
        fillCount = fillCount + 1;
    }



    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("RingBuffer underflow");
        }
        T p = rb[first];
        rb[first++] = null;
        if (first > capacity - 1) {
            first = 0;
        }
        fillCount--;
        return p;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("RingBuffer underflow");
        }
        return rb[first];
    }

    /**
     * 这个方法是实现iterator方法以便于实现foreach语法.
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }

    /**
     * 定义一个Iterator用于上述方法的反悔，
     */
    private class ArrayQueueIterator implements Iterator<T> {
        /*内置的Num*/
        private int iterNum;

        /**
         * 使用private修饰的类不允许有public方法.
         * 构造器.
         */
        ArrayQueueIterator() {
            iterNum = 0;
        }

        /**
         * 用于判断是否遍历了所有的成员.
         * @return
         */
        @Override
        public boolean hasNext() {
            return iterNum < fillCount;
        }

        /**
         * 用于返回下一个成员.
         * @return
         */
        @Override
        public T next() {
            int index = (iterNum + first) % capacity;
            iterNum++;
            return (T) rb[index];
        }
    }
}
