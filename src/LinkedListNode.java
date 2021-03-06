public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> next; // link to the next element in the list

    public LinkedListNode(T data){
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public LinkedListNode<T> getNext() {
        return next;
    }
    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

}
