/* Online Java Compiler and Editor */
import java.util.concurrent.Semaphore;
import java.util.Random;

public class ReaderWriter extends Thread {
    // shared memory location
    static int sharedData = 0;
    // semaphore for writer access
    static Semaphore writeSemaphore = new Semaphore(1);
    
    // Function to run for threads
    public void run() {
        // Randomly decide to read or write
        Random rand = new Random();
        int writeOrRead = rand.nextInt(2);
        // If 0, we read
        if (writeOrRead == 0) {
            // read shared data; we don't need to lock access for reading
            System.out.println("Reader " + this.getId() + " read shared data: " + sharedData);
        } else {
            // Write data; we need to access the semaphore before we can write
            try {
                // wait for writer access
                writeSemaphore.acquire();
                // write to shared data
                sharedData++;
                System.out.println("Writer " + this.getId() + " wrote to shared data: " + sharedData);
                // release writer access
                writeSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // create 25 ReaderWriter threads
        for (int i = 0; i < 25; i++) {
            new ReaderWriter().start();
        }
    }
}