/* Online Java Compiler and Editor */
public class ScopeForLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside for loop: i = " + i);
        }
        // i is not visible outside the for loop
        // This will break the program: "error: cannot find symbol"
        // System.out.println("Outside for loop: i = " + i);
    }
}
