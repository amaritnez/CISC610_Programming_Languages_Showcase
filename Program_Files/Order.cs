/* Online C# Compiler and Editor */
using System;

public class Order {
    // Function that returns 5 for order of operations test
    public static float orderNumberTest() {
        return 4;
    }

    public static void Main(string[] args) {
        // Perform the math, also calling the function as necessary
        float orderTest = 2 * 3 / orderNumberTest() + 5;
        // Print final results
        Console.WriteLine("2 * 3 / orderNumberTest() + 5 = " + orderTest);
    }
}
