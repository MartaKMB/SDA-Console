package pl.sda.fibonacci.impl;

import pl.sda.fibonacci.Fibonacci;

// pierwsze zajecia z Michalem

public class FibonacciRecursive implements Fibonacci {

    @Override
    public long getN(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getN(n - 1) + getN(n - 2);
        }
    }
}
