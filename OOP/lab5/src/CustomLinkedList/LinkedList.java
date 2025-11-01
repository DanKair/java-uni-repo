package CustomLinkedList;

public class LinkedList<T> {
    private Node <T> head;
    private Node <T> tail;
    private int size = 0;

    // Add element to the end
    public void add(T data){
        // Creating newNode object and passing data parameter to it
        Node<T> newNode = new Node<>(data);

        // If head references to null, then it's empty, so newNode becomes both head and tail
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            // Initialize Node for Traversing as head
            Node<T> current = head;
            // Searching from head until we find reference to null (end of the list)
            while (current.next != null) {
                // Jump to the next node
                current = current.next;
            }
            current.next = newNode;
            // Node pointing to null == Tail
            tail = current.next;
        }
        size++;
    }

    // Add new Node to the start
    public void addToHead(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add new Node at the end
    public void addToTail(T data){
        Node<T> newNode = new Node<>(data);

        // If tail references to null, then it's empty, so newNode becomes head
        if (tail == null){
            tail = newNode;
        }
        else{
            tail.next = newNode;
        }
        size++;
    }

    // Delete Element by its Value
    public void remove(T value){
        // 1. Traverse the List until the node with matching value found
        // 2. if found: change the pointer to the next.next node
        Node <T> node = head;

        // If the head gonna be deleted, then move head to next element
        if (head.data == value){
            head.next = head;
            return;

        }
        else {
            // TODO: Handle Logic for Deleting of the Tail Node
            while (node.next != null){
            if (node.next.data == value){
                node.next = node.next.next;
            }
            node = node.next;
        }
        }

    }

     // Get element at index
    public T getByIndex(int index) {
        checkBounds(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void getElementByValue(T value){
        // 1. Traverse through the list (while node != null)
        // 2. if node.data == value: return node
        // 3. Else: keep going
        Node <T> node = head;
        if (head.data == value){
            System.out.println(head.data);
        }
        while (node.next != null){
            if (node.next.data == value){
                System.out.println(head.next.data);;
            }
            node = node.next;
        }
        System.out.println("Node with value: " + value + " wasn't found.");;
    }

    // Search element by value and return its index like Linear Search
    public int search(T value){
        // 0. Keep track of indexes from 0 as head
        // 1. Keep traversing until you find the node with matching value
        // 2, If found: return index;
        // 3. else: return -1 like in linear search;
        int index = 0;
        Node<T> node = head;

        // This version of traversing returns NullPointerException
        /*
        while (node.data != value){
            node = node.next;
            index += 1;
        }
        */

        while (node.next != null){
            index += 1;
            if (node.next.data == value){
                return index;
            }
            node = node.next;
        }
        return -1;



    }

    // Size of the list
    public int size() {
        return size;
    }

    // Check index bounds
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Getter Methods
    public Node<T> getTail(){
        return tail;
    }

    public void printList(){
        // If head points to null, then it's empty list
        if (head == null){
            System.out.println("List is empty.");
            return;
        }
        // Traverse through the list until we reach the end (null value) starting from head
        Node<T> current = head;
        while (current != null){
            System.out.print(current.data);
            // If next node after current node also doesn't point to null, then keep going
            if (current.next != null){
                System.out.print(" --> ");
            }
            current = current.next;

        }
        System.out.println();

    }



}
