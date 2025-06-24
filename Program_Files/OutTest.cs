/* Online C# Compiler and Editor */
using System;

class OutTest
{
    static void Main(string[] args)
    {
        // Setup variables first
        int x = 10;
        int y = 20;
        int z;
        // Print inital values
        Console.WriteLine("Before method call:");
        Console.WriteLine("x = " + x);
        Console.WriteLine("y = " + y);
        // Call function with out variables
        TestMethod(out x, y, out z);
        // Print values after the function ran
        Console.WriteLine("After method call:");
        Console.WriteLine("x = " + x);
        Console.WriteLine("y = " + y);
        Console.WriteLine("z = " + z);
    }

    // Function to showcase out variables for test
    static void TestMethod(out int a, int b, out int c)
    {
        // Assign values for the two out variables
        a = 30;
        c = 40;
        // Print their values
        Console.WriteLine("Inside method:");
        Console.WriteLine("a = " + a);
        Console.WriteLine("b = " + b);
        Console.WriteLine("c = " + c);
    }
}
