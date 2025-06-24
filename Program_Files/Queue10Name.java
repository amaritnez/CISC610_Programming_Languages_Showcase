public class Queue10Name {

    // Node class to track elements in the queue
    private class Node {
        char[] data = new char[10];
        Node next;

        public Node(char[] data) {
            this.data = data;
            this.next = null;
        }
    }

    // Track front and end of queue
    private Node front;
    private Node rear;

    // Constructor
    public Queue10Name() {
        front = null;
        rear = null;
    }

    // Adds an element to back of queue
    public void enqueue(char[] name) {
        // Create new node with the provided name
        Node newNode = new Node(name);
        // If queue is empty
        if (isEmpty()) {
            // Put this element to front
            front = newNode;
        } else {
            // the last element is no longer last, add a new node next to it
            rear.next = newNode;
        }
        // Mark new element as last
        rear = newNode;
    }

    // Remove an element from front of queue
    // Returns the removed element's name
    public char[] dequeue() throws NoSuchElementException {
        // Check if queue is empty, obviously don't do anything if it is
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Get name of current front element
        char[] name = front.data;
        // Front is no longer in front, mark node next to it as front
        front = front.next;
        // If this was the last element, mark rear of the queue as empty too
        if (front == null) {
            rear = null;
        }
        return name;
    }

    // Remove all elements from the queue
    public void empty() {
        // While the front is not empty i.e. there are more elements to remove
        while (front != null) {
            // Simply point front to the next element
            front = front.next;
        }
        // Once we get here, queue. Mark rear as null too
        rear = null;
    }

    // Check if the queue is empty (duh)
    public boolean isEmpty() {
        return front == null;
    }
}
