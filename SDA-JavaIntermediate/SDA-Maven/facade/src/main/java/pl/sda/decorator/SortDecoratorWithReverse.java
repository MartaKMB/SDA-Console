package pl.sda.decorator;

import pl.sda.sort.Sort;

public class SortDecoratorWithReverse implements Sort {

//    pole do obiektu z klasy implementujacej Sort

    private Sort sort;

    public SortDecoratorWithReverse(Sort sort) {
        this.sort = sort;
    }

//    dekoracja poprzez odwrocenie kolejnosci

//    Override - pokazuje, ze metoda przykrywa metode implementowana

    @Override
    public int[] sort(int[] arrayToSort) {
        int[] result = sort.sort(arrayToSort);
        int[] reversedResult = new int[arrayToSort.length];
        for (int i = 0; i < arrayToSort.length; i++) {
            reversedResult[i] = result[arrayToSort.length - i - 1];
        }
        return reversedResult;
    }

//    test jednostkowy
}
