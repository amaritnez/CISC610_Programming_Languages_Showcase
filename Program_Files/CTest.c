/* Online C Compiler and Editor */
#include <stdio.h>

// Takes in an int and prints it
void foo(int x)
{
    printf("%d\n", x);
}


int main()
{
    // Define float
    float f = 1.5;
    // Assign float to int
    int i = f;

    // Declare int, float, and double
    int j = 10;
    float k = 2.5;
    double d = 3.0;
    // Do math between the 3 different types
    i = i + f;
    d = f * d;
    // Call function, pass in a float even tho function parameter is an int
    foo(f);
    // Print to see if the program makes it this far
    printf("Hello, World!\n");
    return 0;
}