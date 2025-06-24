public class SingleLinkedList {

    private class Node {
        public Node link;
        public int contents;
    }

    private Node head;

    public SingleLinkedList() {
        head = null;
    }

    public void insertAtHead(int value);

    public void insertAtTail(int value);

    public int removeAtHead();

    public boolean isEmpty();

}

public class Stack2 extends SingleLinkedList {

    public Stack2() {
        super();
    }

    public void push(int value) {
        insertAtHead(value);
    }

    public int pop() {
        return removeAtHead();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

}

public class Queue2 extends SingleLinkedList {

    public Queue2() {
        super();
    }

    public void enqueue(int value) {
        insertAtTail(value);
    }

    public int dequeue() {
        return removeAtHead();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

}