package pl.sda.sort.impl;

import org.junit.Test;
import pl.sda.sort.Sort;

import static org.junit.Assert.fail;

public class CountSortTest {
    @Test
    public void testSort() {
        int[] input = {5, 6, 1, 77, 1, 0, -11, 23, -1321, -3131};

        Sort sorter = new CountSort();

        try {
            int[] sort = sorter.sort(input);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Wyjatek");
        }
    }
}
