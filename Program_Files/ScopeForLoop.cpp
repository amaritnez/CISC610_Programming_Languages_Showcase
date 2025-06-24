/* Online C++ Compiler and Editor */
#include <iostream>
using namespace std;

int main() {
    // Print i 5 times lol
    for (int i = 0; i < 5; i++) {
        std::cout << "Inside for loop: i = " << i << std::endl;
    }
    // i is not visible outside the for loop
    // This will break the program: "error: 'i' was not declared in this scope"
    // std::cout << "Outside for loop: i = " << i << std::endl; 
    return 0;
}