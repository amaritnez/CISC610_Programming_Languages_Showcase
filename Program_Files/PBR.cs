/* Online C# Compiler and Editor */
using System;

class PBR
{
    // Function to attempt to modify the referenced variable
    static void changeByRef(ref int value)
    {
        value = 10;
        // Print the modififed results
        Console.WriteLine(value);
    }

    static void Main(string[] args)
    {
        // Pass a literal of 5 by reference
        changeByRef(ref 5);
    }
}