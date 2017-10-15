package pl.sda.fibonacci.impl;

import pl.sda.fibonacci.Fibonacci;

import java.util.ArrayList;
import java.util.List;

// pierwsze zajecia z Michalem

public class Main {

    public static void main(String[] args) {
        Fibonacci fibonacciRecursive = new FibonacciRecursive();
        Fibonacci fibonacciIterational = new FibonacciIterational();

//        lista trzymajaca obiekty typu fionacci
//        dzieki temu, ze obie klasy implementuja ten sam interfejs
//        mozemy trzymac je na jednej liscie i jedna petla moze je obsluzyc jedna petla

        List<Fibonacci> listaFib = new ArrayList<>();
        listaFib.add(fibonacciRecursive);
        listaFib.add(fibonacciIterational);

        for (Fibonacci fib : listaFib) {
            System.out.println(fib.getN(5));
        }

        System.out.println(fibonacciRecursive.getN(5));
        System.out.println(fibonacciIterational.getN(5));
    }
}
