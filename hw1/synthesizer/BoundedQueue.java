package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{

    int capacity();
    int fiiCount();
    void enqueue(T X);
    T dequeue();
    T peek();

    default boolean isEmpty(){
        if(fiiCount() == 0)
            return true;
        return false;
    }

    default boolean isFull(){
        if(fiiCount() == capacity())
            return true;
        return false;
    }

}
