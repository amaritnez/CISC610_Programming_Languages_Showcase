/* Online Java Compiler and Editor */
import java.util.Random;

public class MatrixMath {

    //  Function to multiply two matrices with logic loops
    //  arryA[][] - first array to multiply
    //  arryB[][] - second array to multiply
    //  return - product of the two arrays (if applicable)
    public static int[][] matrixMultiplyLogical(int[][] arryA, int[][] arryB) throws Exception {
        // Check if multiplication is possible
        if (arryA[0].length != arryB.length) {
            System.out.println("Lengths don't match: " + arryA[0].length + " " + arryB.length);
            throw new Exception("Can't multiply these matricies!");
        }
        // Setup return matrix; dimensions match outer dimensions of 2 matrices
        int[][] retArry = new int[arryA.length][arryB[0].length];
        // setup out counter
        int i = 0;
        // Iterate through outer dimension of matrix A
        while (i < arryA.length) {
            int j = 0;
            // Iterate through outer dimension of matrix B
            while (j < arryB[0].length) {
                int k = 0;
                // Inner dimensions represent how much we are multiplying
                while (k < arryA.length) {
                    // Multiply kth element of row I in matrix A by kth element of row J in matrix B
                    retArry[i][j] += arryA[i][k] * arryB[k][j];
                    k++;
                }
                j++;
            }
            i++;
        }
        // Return calculated matrix
        return retArry;
    }

    //  Function to multiply two matrices with counter loops
    //  arryA[][] - first array to multiply
    //  arryB[][] - second array to multiply
    //  return - product of the two arrays (if applicable)
    public static int[][] matrixMultiplyCounter(int[][] arryA, int[][] arryB) throws Exception {
        int[][] retArry = new int[arryA.length][arryB[0].length];
        // Check if multiplication is possible
        if (arryA[0].length != arryB.length) {
            System.out.println("Lengths don't match: " + arryA[0].length + " " + arryB.length);
            throw new Exception("Can't multiply these matricies!");
        }

        // Iterate through all rows/columns
        for (int i=0; i < retArry.length; i++) {
            for (int j=0; j < retArry[0].length; j++) {
                // Inner dimensions represent how much we are multiplying
                for (int k = 0; k < arryB.length; k++) {
                    // Multiply kth element of row I in matrix A by kth element of row J in matrix B
                    retArry[i][j] += arryA[i][k] * arryB[k][j];
                }
            }
        }
        // Return calculated matrix
        return retArry;
    }

    public static void main(String []args) throws Exception {
        // Setup rng with fixed seed
        Random rand = new Random(10);
        // Make two random matricies
        int[][] arryA = new int[4][4];
        System.out.println("Array 1:");
        // Iterate through all rows/columns
        for (int i = 0; i < arryA.length; i++) {
            for (int j = 0; j < arryA[0].length; j++) {
                // generate random integer values between 0 and 10
                arryA[i][j] = rand.nextInt(10);
                System.out.print(arryA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        int[][] arryB = new int[4][4];
        System.out.println("Array 2:");
        // Iterate through all rows/columns
        for (int i = 0; i < arryB.length; i++) {
            for (int j = 0; j < arryB[0].length; j++) {
                // generate random integer values between 0 and 10
                arryB[i][j] = rand.nextInt(10);
                System.out.print(arryB[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        // Call function for counter based multiplication
        //int[][] finalArry = matrixMultiplyCounter(arryA, arryB);
        // Call function for logic based multiplication
        int[][] finalArry = matrixMultiplyLogical(arryA, arryB);
        // Print out final array results
        System.out.println("Final Array!");
        // Iterate through all rows/columns
        for (int i = 0; i < finalArry.length; i++) {
            for (int j = 0; j < finalArry[0].length; j++) {
                System.out.print(finalArry[i][j] + " ");
            }
            System.out.println();
        }
    }
}