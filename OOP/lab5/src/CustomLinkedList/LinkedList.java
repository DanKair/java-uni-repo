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
        // Newly created Node now points to previous head
        newNode.next = head;
        // Newly created Node becomes Head
        head = newNode;
        size++;
    }

    // Add new Node at the end
    public void addToTail(T data){
        // TODO: Fix tail overwriting issue
        Node<T> newNode = new Node<>(data);

        // If tail references to null, then it's empty, so newNode becomes tail
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
            // Head becomes next element after head
            head = head.next;
            size--;
            return;

        }
        else {
            // TODO: Handle Logic for Deleting of the Tail Node
            while (node.next != null){
            if (node.next.data == value){
                node.next = node.next.next;
                break; // Added this to break after first occurence of value assuming List stores unique elements
            }
            node = node.next;
            size--;
        }
        }

    }

    public void deleteByPosition(int index){
        // 1. Iterate till the index range starting from the head
        // 2. Change the pointer of current Node to next Node
        // TODO: Add Index Out of Range / NullPointerException handling
        checkBounds(index);
        Node <T> node = head;

        // If index points to head, then make next element after head as new Head
        if (index == 0){
            head = head.next;
            size--;
            return; // exits execution of the method
        }

        // Why index - 1? Because you need to shift the pointer of previous Node before target Node to the pointer of Target Node
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
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

        if (head.data == value){
            return index; // returns 0 index
        }

        while (node.next != null){
            index += 1;
            if (node.next.data == value){
                return index;
            }
            node = node.next;
        }
        return -1;



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

    // Size of the list
    public int size() {
        return size;
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

    /*
    public void printReverseList(){
        // Iterate from Tail to head in Original LinkedList (node = tail)
        //      a. Get the Original LinkedList size
        //      b. for (int i = size; i > 0; i--)
        Node <T> current = getTail();
        while (current != head){
            System.out.println(current.data);

            if (current.next != head){
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();


    }
     */

    public void reverseList(){
        // Reverse LinkedList using 3 pointers (prev, current, next)
        // 1. Initalize prev as null, current as head, and next = current.next
        // 2. Iterate till the tail
        // 3. After each iteration, change the pointer of current to prev (current.next = prev)

        Node<T> prev = null;
        Node<T> current = head;
        while (current != null){
            // Creating 3 pointer variable next
            Node<T> next = current.next;
            // Reversing Pointing of current Node (<--) to previous Node
            current.next = prev;
            // Moving previous to right (by making it current Node)
            prev = current;
            // Moving current to right (by making it as next)
            current = next;
        }
    }
}
