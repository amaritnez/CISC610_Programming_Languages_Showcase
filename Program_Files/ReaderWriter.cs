/* Online C# Compiler and Editor */
using System;
using System.Threading;

public class ReaderWriter : Thread
{
    // shared memory location
    static int sharedData = 0;
    // semaphore for writer access
    static Semaphore writeSemaphore = new Semaphore(1, 1);

    // Function to run for threads
    public void run()
    {
        // Randomly decide to read or write
        Random rand = new Random();
        int writeOrRead = rand.Next(2);
        // If 0, we read
        if (writeOrRead == 0)
        {
            // read shared data; we don't need to lock access for reading
            Console.WriteLine("Reader " + this.Id + " read shared data: " + sharedData);
        }
        else
        {
            // Write data; we need to access the semaphore before we can write
            try
            {
                // wait for writer access
                writeSemaphore.WaitOne();
                // write to shared data
                sharedData++;
                Console.WriteLine("Writer " + this.Id + " wrote to shared data: " + sharedData);
                // release writer access
                writeSemaphore.Release();
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }

    public static void Main()
    {
        // create 25 ReaderWriter threads
        for (int i = 0; i < 25; i++)
        {
            new ReaderWriter().Start();
        }
    }
}
