package pl.sda.mvc.controller;

import pl.sda.fibonacci.Fibonacci;
import pl.sda.fibonacci.impl.FibonacciIterational;
//import pl.sda.mvc.model.Model;
import pl.sda.mvc.model.ModelFacade;

import java.util.List;
//import java.util.Random;

public class Controller {

//    w nim metody

    public long getFibValue (int n) {

//        dostep do fibonacci, wiec zmieniamy

        Fibonacci fib = new FibonacciIterational();
        long val = fib.getN(n);

//        zmiana wywolan z Model'u na ModelFacade

        ModelFacade.addValueThroughFacade(val);
        return val;

        /*
//        wyrzucamy losowa liczbe
        Random random = new Random();

//      dodawanie wartosci do listy
        int val = random.nextInt(2000);
        Model.addValue(val);
        return val;
        */
    }

//    metoda zwracajaca srednia

    public double average () {
        double sum = 0;

//     pobierz tablice z modelu, w zalozeniu tablica pobierana z modelu

        List<Long> values = ModelFacade.getValuesThroughFacade();

        for (long val : values) {
            sum = sum + val;
        }

        return sum / values.size();
    }
}
