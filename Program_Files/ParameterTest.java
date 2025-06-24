import java.util.Random;

public class ParameterTest {

    // number of times to call subprograms
    private static final int NUM_TRIALS = 1000000; 

    public static void main(String[] args) {       
        
        // Create rng
        Random rand = new Random();
        // single parameter for first subprogram
        int singleParam = rand.nextInt(); 
        // 20 parameters for second subprogram
        int[] twentyParams = new int[20]; 
        // Give random numbers for each parameter
        for (int i = 0; i < 20; i++) {
            twentyParams[i] = rand.nextInt();
        }
        // Start time tracking for single function
        long startTime = System.nanoTime();
        for (int i = 0; i < NUM_TRIALS; i++) {
            singleParamOp(singleParam);
        }
        // end time
        long endTime = System.nanoTime();
        // And save
        long singleParamTime = endTime - startTime;
        // Start time for 20 param function
        startTime = System.nanoTime();
        for (int i = 0; i < NUM_TRIALS; i++) {
            twentyParamsOp(twentyParams[0], twentyParams[1], twentyParams[2], twentyParams[3], twentyParams[4],
                    twentyParams[5], twentyParams[6], twentyParams[7], twentyParams[8], twentyParams[9],
                    twentyParams[10], twentyParams[11], twentyParams[12], twentyParams[13], twentyParams[14],
                    twentyParams[15], twentyParams[16], twentyParams[17], twentyParams[18], twentyParams[19]);
        }
        // End and save time
        endTime = System.nanoTime();
        long twentyParamsTime = endTime - startTime;
        // Print time results
        System.out.println("Time for single parameter subprogram: " + singleParamTime + " nanoseconds");
        System.out.println("Time for twenty parameter subprogram: " + twentyParamsTime + " nanoseconds");
        System.out.println("Ratio of time required with 20 parameters to time required by 1 parameter subprograms: " + ((double) twentyParamsTime / singleParamTime));
    }

    // Perform some simple operation on x
    public static void singleParamOp(int x) {        
        int y = x * 2;
    }

    // Use all 20 parameters to perform some simple operation
    public static void twentyParamsOp(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10,
            int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20) {        
        int result = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10 + p11 + p12 + p13 + p14 + p15 + p16 + p17 + p18 + p19 + p20;
    }
}
