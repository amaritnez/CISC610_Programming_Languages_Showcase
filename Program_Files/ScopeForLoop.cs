/* Online C# Compiler and Editor */
using System;
class ScopeForLoop {
    static void Main() {
        for (int i = 0; i < 5; i++) {
            Console.WriteLine("Inside for loop: i = " + i);
        }
        // i is not visible outside the for loop
        // This will break the program: "error: The name 'i' does not exist in the current context"
        // Console.WriteLine("Outside for loop: i = " + i);
    }
}