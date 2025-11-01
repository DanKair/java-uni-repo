package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        // Node class Demo
        Node firstNode = new Node<>(5);
        Node secondNode = new Node<>(10);
        Node thirdNode = new Node<>(20);
        Node forthNode = new Node<>(50);
        firstNode.next = secondNode;
        //firstNode.next.next = thirdNode;
        secondNode.next = thirdNode;
        thirdNode.next = forthNode;
        System.out.println("Node class Demo: " + firstNode);
        System.out.println("===============================");

        // LinkedList class Implementation Logic
        LinkedList linkedList = new LinkedList();
        linkedList.add(firstNode.data);
        // Created linkedlist object and passed  to it 5 as data
        System.out.println("Tail of the Linked List: " + linkedList.getTail());
        System.out.println("Size of the Linked List: " + linkedList.size());

        linkedList.add(secondNode.data);
        System.out.println("Tail of the Linked List: " + linkedList.getTail());

        linkedList.add(thirdNode.data);
        System.out.println("Tail of the Linked List: " + linkedList.getTail());

        linkedList.add(forthNode.data);
        System.out.println("Tail of the Linked List: " + linkedList.getTail());

        linkedList.addToTail(40);
        System.out.println("Tail of the Linked List: " + linkedList.getTail());
        System.out.println("===============================");

        //linkedList.addToHead(50);
        linkedList.printList();
        System.out.println("Linear Search Result: " + linkedList.search(50));
        //System.out.println("Element At the position 3: " + linkedList.getByIndex(3));

        linkedList.remove(20);
        linkedList.printList();
        System.out.println("Size of the Linked List: " + linkedList.size());

        linkedList.remove(5);
        linkedList.printList();
        System.out.println("Size of the Linked List: " + linkedList.size());

        linkedList.deleteByPosition(2);
        linkedList.printList();
        System.out.println("Size of the Linked List: " + linkedList.size());
        System.out.println("Tail of the Linked List: " + linkedList.getTail());
    }
}
