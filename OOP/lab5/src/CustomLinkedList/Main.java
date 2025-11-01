package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        // Node class Demo
        Node firstNode = new Node<>(5);
        Node secondNode = new Node<>(10);
        Node thirdNode = new Node<>(20);
        firstNode.next = secondNode;
        //firstNode.next.next = thirdNode;
        secondNode.next = thirdNode;
        System.out.println(firstNode);

        // LinkedList class Implementation Logic
        LinkedList linkedList = new LinkedList();
        linkedList.add(firstNode.data);
        // Created linkedlist object and passed  to it 5 as data
        System.out.println(linkedList.getTail());

        linkedList.add(secondNode.data);
        System.out.println(linkedList.getTail());

        linkedList.add(thirdNode.data);
        System.out.println(linkedList.getTail());

        linkedList.addToTail(40);
        System.out.println(linkedList.getTail());

        //linkedList.addToHead(50);
        linkedList.printList();
        System.out.println("Linear Search Result: " + linkedList.search(50));
        //System.out.println("Element At the position 3: " + linkedList.getByIndex(3));

        linkedList.remove(20);
        // linkedList.remove(5); // TODO: Handle Deleting of the Head Node
        linkedList.printList();
    }
}
