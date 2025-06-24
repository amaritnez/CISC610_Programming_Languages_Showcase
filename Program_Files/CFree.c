/* Online C Compiler and Editor */
#include <stdlib.h>
#include <stdio.h>

int main() {
    // Alloc a pointer with the size of the int data type
    int *ptr = malloc(sizeof(int));
    // Check if alloc goes smoothly
    if (ptr == NULL) {
        printf("Error: Failed to allocate memory\n");
        return 1;
    }
    // Set ptr value to 42 (the answer to everything)
    *ptr = 42;
    printf("Value: %d\n", *ptr);
    // Moment of truth, see if this works
    free(ptr);
    return 0;
}