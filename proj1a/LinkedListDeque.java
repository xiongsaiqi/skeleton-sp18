public class LinkedListDeque<T> {
    //    内嵌一个node 类
    public class ldNode {
        public T item;
        public ldNode next;
        public ldNode prev;

        public ldNode(T item){
            this.item = item;
        }
    }

    //成员变量
//    使用crircle结构，那么sentinel指向的就是最后一个节点。
    private ldNode sentinel;
    private int size;

    //    构造方法，创建一个新的LinkListDeque

//    空白留给答案吧
    public LinkedListDeque(){
        sentinel = new ldNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    //    添加第一个
    public void addFirst(T x) {
        ldNode p = new ldNode(x);
        sentinel.next.prev = p;
        p.next = sentinel.next;
        sentinel.next = p;
        p.prev = sentinel;
        size++;
    }

    //使用casting方法来addLast
    public void addLast(T x) {
        ldNode p = new ldNode(x);
        ldNode m = sentinel;
        while(m.next != sentinel){
            m = m.next;
        }
        p.next = m.next;
        m.next.prev = p;
        m.next = p;
        p.prev = m;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ldNode p = sentinel.next;
        while(p.next!=sentinel){
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
            ldNode p = sentinel.next;
            sentinel.next = p.next;
            p.next.prev = sentinel;
            size--;
            return p.item;
        }


    public T removeLast() {
        ldNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.item;
    }

    public T get(int index) {
        ldNode p = sentinel.next;
        if(index >= size){
            return null;
        }else{
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        return p.item;

    }

    public T getRecursive(int index){
        ldNode p = sentinel.next;
        if(index >= size){
            return null;
        }else{
            return getNode(p, index).item;
        }

    }

    private ldNode getNode(ldNode p, int index) {
        if (index == 0) {
            return p;
        } else {
            p = p.next;
            index--;
            return getNode(p, index);
        }
    }
}
