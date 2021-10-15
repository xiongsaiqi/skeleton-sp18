import java.io.ObjectStreamException;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int factor = 2;

    public ArrayDeque(){
        items = (T[])new Object[8];
        size = 0;
        int nextFirst = 3;
        int nextLast = 4;
    }

    public void addFirst(T item){
       if(nextFirst == nextLast)
           resize(2);
       items[nextFirst] = item;
        nextFirst = (nextFirst-1+items.length)% items.length;
       size++;
    }
    
    public void addLast(T item){
       if(nextLast  == nextFirst)
           resize(2);
       items[nextLast] = item;
       nextLast = (nextLast + 1) % items.length;
       size++;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++) {
            int index = (nextFirst + 1 + i) % items.length;
            System.out.println(items[index]+"\t");
        }
    }

    public T removeFirst(){
        if((float)(size/ items.length) <= 0.25 && items.length >= 16)
            resize(0.5f);
//        这里不用+len因为加不可能超过边界，但是减才有可能
        int first = (nextFirst + 1)% items.length;
        T item = items[first];
        items[first] = null;
        nextFirst = first;
        size--;
        return item;
    }

    public T removeLast(){
        if((float)(size/ items.length) <= 0.25 && items.length >= 16)
           resize(0.5f);
        int last = (nextLast - 1 + items.length)% items.length;
        T item = items[last];
        items[last] = null;
        nextLast = last;
        size--;
        return item;
    }

    public T get(int index){
        int array_index = (nextFirst + 1 + index)%items.length;
        return items[array_index];
    }

    private void resize(float factor){
//        too ugly
        int new_size = (int)(factor * items.length);
        T[] new_items = (T[]) (new Object[new_size]);
        for (int i = 0; i < size; i++) {
            int newIndex = (nextFirst - 1 + i) % new_items.length;
            int oldIndex = (nextFirst - 1 + i) % items.length;
            new_items[i] = items[i];
            nextLast = (nextFirst + i) % new_items.length;
        }
        items = new_items;
    }
}
