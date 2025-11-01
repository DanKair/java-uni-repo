package CustomLinkedList;

public class Node <T>{
    // Value that Node stores (like some number)
    public T data;
    // Reference to the next Node
    public Node <T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /*@Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
     */

    @Override
    public String toString(){
        return data + " --> " + next;
    }
}
