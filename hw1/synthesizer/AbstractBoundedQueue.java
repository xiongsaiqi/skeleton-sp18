package synthesizer;

/**
 * 这个类主要是用于集成BoundedQueue接口，然后实现部分代码，设置部分变量等等。
 * 这个类的设置主要是模拟常见的数据结构不如map collection等等，为了节省代码
 * 他们通常都是集成一个抽象类然后抽象类实现某些接口。这样可以决定哪些方法是需要实现
 * 哪些方法并不需要实现.
 * @author 熊赛棋
 * @param <T>
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /*填入元素的个数。*/
    protected int fillCount;
    /*这个数据结构的容量。*/
    protected int capacity;

    /**
     * 返回这个数据结构的容量.
     * @return
     */
    public int capacity() {
        return capacity;
    }

    /**
     * 返回这个Queue所填入的数量.
     * @return
     */
    public int fillCount() {
        return fillCount;
    }
}

