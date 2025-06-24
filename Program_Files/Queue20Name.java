public class Queue20Name {

    // Node class to track elements in the queue
    private class Node {
        char[] data = new char[20];
        Node next;
        // New value; tracks the priority of this node in the queue
        int priority;

        public Node(char[] data, int priority) {
            this.data = data;
            this.next = null;
            this.priority = priority;
        }
    }

    // Track front and end of queue
    private Node front;
    private Node rear;

    // Constructor
    public Queue20Name() {
        front = null;
        rear = null;
    }

    // Adds an element to back of queue
    public void enqueue(char[] name, int priority) {
        // Create new node with the provided name
        Node newNode = new Node(name, priority);
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

    // Remove an element based on location and priority
    // Highest priority value is returned, in an event of tie, furthest element
    // Returns the removed element's name
    public char[] dequeue() throws NoSuchElementException {
        // Check if queue is empty, obviously don't do anything if it is
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        // Get node we plan to return
        Node ret = front;
        // We need to iterate through whole queue since it is unordered to check for priority
        Node iterate = front;
        while (iterate.next != null) {
            // If next element has a high priority, save it's name
            if (iterate.next.priority > ret.priority) {
                ret = iterate.next;
            }
            // Move on to next element
            iterate = iterate.next;
        }

        // If the front element is the one to be removed, don't run the fancy loop logic
        if (ret == front) {
            // Front is no longer in front, mark node next to it as front
            front = front.next;
        } else {
            // Now we found the node to remove, let's iterate throug the queue again, and update
            // Missing links as necessary
            iterate = front;
            while (iterate.next != null) {
                // If next element is the removed node
                if (iterate.next ==  ret) {
                    // Simply make the returned node's next this one
                    iterate.next = ret.next;
                    // We can also end the loop, we don't need to keep going
                    break;
                }
                // Move on to next element
                iterate = iterate.next;
            }
        }
        // If this was the last element, mark rear of the queue as empty too
        if (front == null) {
            rear = null;
        }
        return ret.data;
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
