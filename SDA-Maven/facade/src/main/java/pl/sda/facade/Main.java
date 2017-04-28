package pl.sda.facade;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        po stworzeniu SortFacade program korzysta juz z niej a nie z Sort z innego projektu

        int[] tab = new int[] {553, 33, 1, 67, 1, 77, 0};
        SortFacade sort = new SortFacade();
        int[] result = sort.sortThroughFacade(tab);
        System.out.println(Arrays.toString(result));
    }
}
