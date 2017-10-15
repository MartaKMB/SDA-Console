package algorytmy.sort;

// pierwsze zajecia z Michalem

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Sort bubbleSort = new BubbleSort();
        Sort countSort = new CountSort();
        Sort selectionSort = new SelectionSort();

//        lista klas, ktore potrafia sortowac

        List<Sort> sorterList = new ArrayList<>();
        sorterList.add(bubbleSort);
        sorterList.add(countSort);
        sorterList.add(selectionSort);

//        w petli sortowanie za kazdym razem z uzyciem innego algorytmu

        int[] listToSort = new int[100];
        for (int i = 0; i < 100; i++) {

//            wypelnianie losowymi wartosciami

            Random rand = new Random();

//            Math.abs - wart bezwzgledna

            listToSort[i] = rand.nextInt(1000);
        }

//        tworzenie tablicy wynikow

        List<int[]> listOfResults = new ArrayList<>();

//        do listy wynikow zadeklarowanej wyzej wpisujemy wynik algorytmu

        for (Sort sorter : sorterList) {
            listOfResults.add(sorter.ascSort(listToSort));
        }

        for (int[] result : listOfResults) {
            System.out.println(Arrays.toString(result));
            /*
            for (int resultVal : result) {
                System.out.println(resultVal);
            }
            */
        }

    }
}
