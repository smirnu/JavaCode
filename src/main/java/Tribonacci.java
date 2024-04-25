/*
    The Tribonacci sequence Tn is defined as follows:

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

    Given n, return the value of Tn.
 */
public class Tribonacci {
    public int tribonacci(int n) {
        if (n < 3) {
            if (n == 0) return 0;
            else return 1;
        }

        // will use three variables to keep the data for the next Tribonacci
        int tribonacciForN1 = 0;
        int tribonacciForN2 = 1;
        int tribonacciForN3 = 1;
        for (int i = 3; i <= n; i++) {
            int tmpFor3 = tribonacciForN3;
            tribonacciForN3 += tribonacciForN1 + tribonacciForN2;
            tribonacciForN1 = tribonacciForN2;
            tribonacciForN2 = tmpFor3;

        }
        return tribonacciForN3;
    }
}
