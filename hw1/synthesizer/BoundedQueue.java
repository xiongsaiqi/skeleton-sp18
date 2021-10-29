package synthesizer;


/**
 * 用于设置一个结构，规定需要实现的方法有capacity()、 fillCount()、等，同时集成Iterable接口，以实现for each
 * 语法。
 * @param <T>
 */
public interface BoundedQueue<T> extends Iterable<T> {
    /**
     * 返回容量.
     * @return
     */
    int capacity();

    /**
     * 返回已经填入Queue的数量.
     * @return
     */
    int fillCount();

    /**
     * 将一个元素入队.
     * @param X
     */
    void enqueue(T X);

    /**
     * 将最先入队的元素出队并返回.
     * @return
     */
    T dequeue();

    /**
     * 返回队列前面的元素，但是不移除.
     * @return
     */
    T peek();

    /**
     * 判断填入元素的数量是否等于0.
     * @return
     */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /**
     * 默认方法，请注意默认方法是不用继承的.
     * @return
     */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
