package pl.sda.observer;

import pl.sda.facade.SortFacade;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        utworzone obiekty obserwatora i fasady a argumentem obserwatorem

        Observer observer = new Observer();
        SortFacade sortFacade = new SortFacade(observer);

//        przygotowanie danych wejsciowych

        int[] input = new int[] {765, -46, 785, -97, 732, 32, -362};

        int[] result = sortFacade.sortUsingCountSort(input);
        System.out.println(Arrays.toString(result));
    }
}
