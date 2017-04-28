package pl.sda.fibonacci.impl;

import pl.sda.fibonacci.Fibonacci;

// pierwsze zajecia z Michalem

public class FibonacciIterational implements Fibonacci {

    @Override
    public long getN(int n) {
        int currentValue = 0;
        if (n == 1) {
            currentValue = 1;
        } else if (n > 1) {
                currentValue = 1;
                int prevValue = 1;
                for (int i = 2; i < n; i++) {
                    int tempValue = currentValue;
                    currentValue = currentValue + prevValue;
                    prevValue = tempValue;
                }
            }
            return currentValue;
        }
}
