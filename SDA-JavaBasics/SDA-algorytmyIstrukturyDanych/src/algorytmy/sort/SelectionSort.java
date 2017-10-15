package algorytmy.sort;

import java.util.Arrays;

public class SelectionSort implements Sort{

    /*
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {1, 24, -2, 3, -5, 8, -2};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(selectionSort.ascSort(array)));
        System.out.println(Arrays.toString(selectionSort.descSort(array2)));
    }
    */

    @Override
    public int[] ascSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexAsc = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[indexAsc] < array[j]) {
                    indexAsc = j;
                }
            }
            SortUtils.swap(array, indexAsc, array.length - i - 1);
        }
        return array;
    }

    @Override
    public int[] descSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexDesc = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[indexDesc] > array[j]) {
                    indexDesc = j;
                }
            }
            SortUtils.swap(array, indexDesc, array.length - i - 1);
        }
        return array;
    }
    }
