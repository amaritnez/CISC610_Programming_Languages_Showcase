/* Online Java Compiler and Editor */
public class Order2 {
    // Function that doubles provided number for order of operations test
    public static int printAndDouble(int num) {
        System.out.println("Printing and doubling " + num);
        return num * 2;
    }
    
    // Function that halbes provided number for order of operations test
    public static int printAndHalf(int num) {
        System.out.println("Printing and halving " + num);
        return num / 2;
    }
    
    // Function that keeps provided number for order of operations test
    public static int printAndKeep(int num) {
        System.out.println("Printing and keeping " + num);
        return num;
    }
    
    // Main method
    public static void main(String[] args) {
        // Call a method with expressions used as actual parameters
        int result = add(printAndHalf(10), printAndDouble(10), printAndKeep(10));
        // Print the result
        System.out.println("Result: " + result);
    }
    
    // Function to add 3 numbers for order of operations test
    public static int add(int x, int y, int z) {
        System.out.println("In add method with " + x + ", " + y + ", " + z);
        return x + y + z;
    }
}
