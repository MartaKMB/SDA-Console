package algorytmy.sort;

import java.util.Arrays;

public class CountSort implements Sort{

    /*
    public static void main(String[] args) {

        CountSort countSort = new CountSort();
        int[] array = {1, 2, 3, -1, -2, -3, 1, 2, 3, 3, 3, 3, 0, 2, 1};
        System.out.println(Arrays.toString(countSort.ascSort(array)));
    }
    */

//        metoda dobra, dla malego zakresu, gdyby bylo np. jedno 1000 to zabierze duzo pamieci

    @Override
    public int[] ascSort(int[] array) {
        int max = SortUtils.max(array);
        int min = SortUtils.min(array);
        int range = max - min + 1;
        int[] rangeArray = new int[range];

//        petla oblicza wystapienia konkretnych wartosci, statystyki

        for (int i = 0; i < array.length; i++) {
            rangeArray[array[i] - min]++;
        }

//        przepisanie statyki, nadpisanie ich

        int index = 0;
        for (int i = 0; i < rangeArray.length; i++) {
            for (int j = 0; j < rangeArray[i] ; j++) {
                array[index] = i + min;

//                powiekszamy index, bo gdybysmy tego nie zrobili za kazdym razem zaczynamy od zerowej wartosci

                index++;
            }
        }
        return array;
    }

    @Override
    public int[] descSort(int[] array) {
        int[] tempArray = ascSort(array);
        int[] result = new int[tempArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            result[i] = tempArray[tempArray.length - i - 1];
        }
        return result;
    }
}
