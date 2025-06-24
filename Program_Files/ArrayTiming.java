import java.util.Arrays;

public class ArrayTiming {
    // Setup constants here
    private static final int ARRAY_SIZE = 1000000;
    private static final int NUM_TRIALS = 10000;

    public static void main(String[] args) {
        // Setup array
        int[] arr = new int[ARRAY_SIZE];
        // This function would've been handy earlier, fill the array with 1's
        Arrays.fill(arr, 1);
        
        // Calculate the times for reference and value
        long timeByReference = timeArrayPassByReference(arr);
        long timeByValue = timeArrayPassByValue(arr);
        // And print them out
        System.out.println("Time by reference: " + timeByReference + " nanoseconds");
        System.out.println("Time by value: " + timeByValue + " nanoseconds");
        System.out.println("Ratio of time by value to time by reference: " + (double) timeByValue / timeByReference);
    }

    // Takes an array, and modifies it using pass by reference
    // Returns the time it took to modify the array
    public static long timeArrayPassByReference(int[] arr) {
        // Start time to track
        long startTime = System.nanoTime();
        // Modify every element of the array
        for (int i = 0; i < NUM_TRIALS; i++) {
            modifyArray(arr);
        }
        return System.nanoTime() - startTime;
    }

    // Takes an array, and modifies it using pass by value
    // Returns the time it took to modify the array
    public static long timeArrayPassByValue(int[] arr) {
        // Start time to track
        long startTime = System.nanoTime();
        // Modify every element of the array
        for (int i = 0; i < NUM_TRIALS; i++) {
            // Since we are passing by value, we must copy the value of the array
            int[] copy = Arrays.copyOf(arr, arr.length);
            // Then pass in the new array with the copied values
            modifyArray(copy);
        }
        return System.nanoTime() - startTime;
    }

    // Function for this test, simply modify the array by adding 1 to every element
    public static void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }
    }
}
