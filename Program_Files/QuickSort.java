/* Online Java Compiler and Editor */
import java.io.*;
import java.util.Stack;

public class QuickSort {

    // Helper function to swap arryay values
    // arry[] - array to be used
    // i - index of first value to be swapped
    // j - index of second value to be swapped
    static void swap(int[] arry, int i, int j) {
        // Save value of i since this gets replaced first
        int tempVal = arry[i];
        // Put value of j into index of i
        arry[i] = arry[j];
        // Put the value of i into index of j using tempVal (since original value is already swapped)
        arry[j] = tempVal;
    }

    // The main function that implements QuickSort via recursion
    //  arry[] - arryay to be sorted,
    //  low - Starting index,
    //  high - Ending index
    static void quickSortRecursive(int[] arry, int low, int high) {
        // Only continue if low index is less than high (if false, then sort is done for this partition)
        if (low < high) {
            // partition the array
            // pivot; default to last value in arryay to begin with
            int pivot = arry[high];
            // initialize the pivot index to the leftmost index
            int newPivotIndex = (low - 1);
            // Iterate through all values in the arryay up to the pivot point
            // Take all values smaller than the pivot and places them behind the pivot
            for (int j = low; j <= high - 1; j++) {
                // If current value is smaller
                // than the pivot
                if (arry[j] < pivot) {
                    // Increment index of
                    // potential pivot (also represents smaller value)
                    newPivotIndex++;
                    // Swap value at proposed pivot index and value at current index
                    swap(arry, newPivotIndex, j);
                }
            }
            // Swap values at the proposed pivot + 1, and the end of the arryay
            // this moves all values greater than the pivot to its right
            swap(arry, newPivotIndex + 1, high);
            // Increase pivot index by one once swaps are done
            newPivotIndex++;
            // Separately sort values before and after the new pivot point
            quickSortRecursive(arry, low, newPivotIndex - 1);
            quickSortRecursive(arry, newPivotIndex + 1, high);
        }
    }

    // The main function that implements QuickSort via iteration
    // arry[] - array to be sorted
    public static void quickSortIterative(int[] arry) {
        // create a stack to store partition indices
        Stack<Integer> stack = new Stack<>();
        // push the initial partition indices onto the stack (first and last values)
        stack.push(0);
        stack.push(arry.length - 1);

        // continue partitioning the array until the stack is empty (i.e. done sorting)
        while (!stack.isEmpty()) {
            // pop the top two partition indices from the stack
            int high = stack.pop();
            int low = stack.pop();

            // partition the array
            // choose the last value as the pivot
            int pivot = arry[high];
            // initialize the pivot index to the leftmost index
            int newPivotIndex = low - 1;
            // iterate through all values in the array
            // Take all values smaller than or equal to the pivot and places them behind the pivot
            for (int j = low; j <= high - 1; j++) {
                // If current value is smaller
                // than the pivot
                if (arry[j] <= pivot) {
                    // Increment index of
                    // potential pivot (also represents smaller value)
                    newPivotIndex++;
                    // Swap value at proposed pivot index and value at current index
                    swap(arry, newPivotIndex, j);
                }
            }
            // Increase pivot index by one
            newPivotIndex++;
            // swap the pivot with the value at the pivot index
            swap(arry, newPivotIndex, high);
            // if there are values to the left of the pivot, push the left partition indices onto the stack
            if (newPivotIndex - 1 > low) {
                stack.push(low);
                stack.push(newPivotIndex - 1);
            }

            // if there are values to the right of the pivot, push the right partition indices onto the stack
            if (newPivotIndex + 1 < high) {
                stack.push(newPivotIndex + 1);
                stack.push(high);
            }
        }
    }

    // Main function for quicksort
    public static void main(String[] args) {
        // Setup arryay of values here
        int[] arry = {5, 67, 19, 54, 1230, 86, 9213, 438, 56, 1220, 94}; // { 9, 56, 8, 7, 0, 123, 56, 34 };

        // Determine which function to run
        if (args.length == 0) {
            System.out.println("Running recursive quicksort");
            // Run recursive quicksort function
            quickSortRecursive(arry, 0, (arry.length) - 1);
        } else {
            System.out.println("Running non-recursive quicksort");
            // Run iterative quicksort function
            quickSortIterative(arry);
        }     
        // Print final arryay
        System.out.println("Sorted arryay: ");
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + " ");
        }
    }
}