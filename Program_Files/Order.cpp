#include <iostream>

using namespace std;

// Function that returns 4 for order of operations test
float orderNumberTest() {
    return 4;
}

int main() {
    // Perform the math, also calling the function as necessary
    float orderTest = 2 * 3 / orderNumberTest() + 5;
    // Print final results
    cout << "2 * 3 / orderNumberTest() + 5 = " << orderTest << endl;
    return 0;
}
