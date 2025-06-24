/* Online Java Compiler and Editor */
public class Order {
    // Function that returns 5 for order of operations test
    public static double orderNumberTest() {
        return 4.0;
    }

    public static void main(String []args) {
        // Perform the math, also calling the function as necessary
        double orderTest = 2 * 3 / orderNumberTest() + 5;
        // Print final results
        System.out.printf("2 * 3 / orderNumberTest() + 5 = %f\n", orderTest);
    }
}