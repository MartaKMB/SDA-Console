package algorytmy.sort;

//import java.util.Arrays;

public class BubbleSort implements Sort{

    /*
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 2, 3, 4, 7, 6, 8};
        int[] array2 = {89, 76, 35, -98, -23, 47};
//        wrap with expression: Arrays.toString - podpowiedz, alt+enter
        System.out.println(Arrays.toString(bubbleSort.ascSort(array)));
        System.out.println(Arrays.toString(bubbleSort.descSort(array2)));
    }
    */

    @Override
    public int[] ascSort(int[] array) {
//        jak jest posortowane, to mniej operacji
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            flag = true;
//            skracanie po kazdym przejciu tablice
            for (int j = 0; j < array.length - 1 - i; j++) {
//                licznik operacji:
                if (array[j] > array[j + 1]) {
//                    przestawiamy wartosci pod indeksem, nie wartosci
                    SortUtils.swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    @Override
    public int[] descSort(int[] array) {
        int counter = 0;
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                counter++;
                if (array[j] < array[j + 1]) {
                    SortUtils.swap(array, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(counter);
        return array;
    }

}
