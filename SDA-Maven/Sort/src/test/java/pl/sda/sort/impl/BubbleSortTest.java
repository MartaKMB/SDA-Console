package pl.sda.sort.impl;

import org.junit.Assert;
import org.junit.Test;
import pl.sda.sort.Sort;

public class BubbleSortTest {

    @Test
    public void testSort() {
        //given
        int[] input = {5, 6, 1, 77, 1, 0, -11, 23, -1321, -3131};

        Sort sorter = new BubbleSort();

        //when
        int[] result = sorter.sort(input);

        //then
        Assert.assertEquals(-3131, result[0]);
        Assert.assertEquals(-1321, result[1]);
        Assert.assertEquals(0, result[3]);
        Assert.assertEquals(23, result[8]);
        Assert.assertEquals(77, result[9]);


    }

    @Test
    public void testSort2() {
        //given
        int[] input = {5, 6, 1, 77, 1, 0, -11, 23, -1321, -3131};

        Sort sorter = new BubbleSort();

        //when
        int[] result = sorter.sort(input);

        //then
        Assert.assertEquals(-3131, result[0]);
        Assert.assertEquals(-1321, result[1]);
        Assert.assertEquals(0, result[3]);
        Assert.assertEquals(23, result[8]);
        Assert.assertEquals(77, result[9]);


    }
}
