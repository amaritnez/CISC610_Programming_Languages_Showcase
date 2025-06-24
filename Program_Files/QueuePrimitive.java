public class QueuePrimitive {

    // Elements of queue, represented as generic array
    private T[] elements;
    // Track front of queue with it's index
    private int front;


    // Constructor
    public QueuePrimitive(int capacity) {
        elements = (T[]) new Object[capacity];
        front = -1;
    }

    // Adds an element to back of queue
    public void enqueue(T element) {
        // Check if queue is full
        if (front == elements.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        // Don't run loop if queue is empty
        if (!isEmpty()) {
            // Iterate through queue, shifting all elements one more forward
            int iterate = front;
            while (iterate > -1 && iterate < elements.length) {
                //System.out.println("Front: " + front);
                elements[iterate+1] = elements[iterate];
                iterate--;
            }
        } else {
            System.out.println("empty :/");   
        }
        // Add new element to rear (0)
        elements[0] = element;
        //System.out.println(elements[0]);
        // Increase front by one
        front++;
    }

    // Remove an element from front of queue
    // Returns the removed element
    public T dequeue() throws NoSuchElementException {
        // Check if queue is empty, obviously don't do anything if it is
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Get element to return
        T element = elements[front];
        elements[front] = null;
        // Decrease front by one
        front--;
        return element;
    }

    // Remove all elements from the queue
    public void empty() {
        // Clear rear element in queue
        elements[0] = null;
        // and reset front index
        front = -1;
    }

    // Check if the queue is empty by seeing if the front index is 0 (duh)
    public boolean isEmpty() {
        return front == -1;
    }
}
